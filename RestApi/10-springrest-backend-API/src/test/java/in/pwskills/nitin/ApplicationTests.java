package in.pwskills.nitin;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//Creating the server and container environment
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)

//mocking the annotations(@RequestBody,@ResponseBody) needed  during Testing
@AutoConfigureMockMvc

//Loading the data from properties file(src/main/resources)
@TestPropertySource("classpath:application.properties")

//this is use to make order of all the methdods that which should run first @Order defines that
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ApplicationTests {

	@Autowired
	public MockMvc mockmvc;
	
	
	@Test
	@DisplayName("Saving student object")
	@Order(1)
	public void testSaveStudent() throws Exception {
		String body = "{\"stdName\":\"sachin\",\"stdGen\":\"Male\",\"stdCourse\":\"SBMS\",\"stdAddr\":\"Mumbai\"}";
		
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.
				post("http://localhost:9999/spring/rest/create").contentType(MediaType.APPLICATION_JSON).
				content(body);
		
		// 2. Send the request and get the response
		MvcResult result=mockmvc.perform(request).andReturn();
		
		// 3. Retrieve the data from request object to perform testing
		MockHttpServletResponse response=result.getResponse();
		
		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		System.out.println("responseStatus is ::"+response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isfalg=response.getContentAsString().contains("CREATED");
		if (!isfalg) {
			fail("STUDENT NOT CREATED!!!");
		}

	}
	
	@Test
	@DisplayName("Getting Student Obj")
	@Order(2)
	public void testGetStudent() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.
				get("http://localhost:9999/spring/rest/getStudent/{id}",1);
		
		//Send the request and get the response
		MvcResult result=mockmvc.perform(request).andReturn();
		
		//3. Retrieve the data from request object to perform testing
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		System.out.println(response.getContentAsString());
	}

	@Test
	@DisplayName("Getting all the students")
	@Order(3)
	public void testGetAllStudent() throws Exception {
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.
				get("http://localhost:9999/spring/rest/getStudentList");
		
		MvcResult result=mockmvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		System.out.println(response.getContentAsString());
	}
	
	@Test
	@DisplayName("update the Student")
	@Order(4)
	public void testUpdateStudent() throws Exception {
		
		String body = "{\"stdId\":1,\"stdName\":\"sachin Tedulkar\",\"stdGen\":\"Male\",\"stdCourse\":\"SBMS\",\"stdAddr\":\"Mumbai\"}";
		
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.
				put("http://localhost:9999/spring/rest/modify").
				contentType(MediaType.APPLICATION_JSON).
				content(body);
		
		MvcResult result=mockmvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isflag=response.getContentAsString().contains("UPDATED");
		if(!isflag) {
			fail("Student Not Updated");
		}
	}
	
	@Test
	@DisplayName("Delete Student")
	public void testDeleteStudent() throws Exception {
		
		MockHttpServletRequestBuilder request=MockMvcRequestBuilders.
				delete("http://localhost:9999/spring/rest/deleteStudent/{id}",1);
		
		MvcResult result=mockmvc.perform(request).andReturn();
		
		MockHttpServletResponse response=result.getResponse();
		
		assertEquals(HttpStatus.OK.value(),response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isflag=response.getContentAsString().contains("DELETED");
		if(!isflag) {
			fail("Student Not deleted");
		}
	}
}
