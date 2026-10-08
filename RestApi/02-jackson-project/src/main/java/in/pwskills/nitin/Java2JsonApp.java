package in.pwskills.nitin;

import java.io.File;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import in.pwskills.nitin.bean.Account;
import in.pwskills.nitin.bean.Order;
import in.pwskills.nitin.bean.Person;

public class Java2JsonApp {
	public static void main(String[] args) throws Exception {

		Order order=new Order(1, "", true, "Good");
		Order order2=new Order(2, "Laptop", false, "Good");
		Order order3=new Order(3, "Watch", false, "Good");
		
		Account account=new Account("1234567899876", "SBI", new BigDecimal(12323));
		
		Person person=new Person("Lovedeep", "Mahalan", "lovedeepmahaln@gmail.com",new Date(), List.of(order,order2,order3), account);
		ObjectMapper mapper=new ObjectMapper();
		
		//this is use to increase the readability of an object
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		//this is use to enable Root_Value (means {} curly braces) for JSON object
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		//this is use for remove NON_NULL and NON_EMPTY value from JSON object that will be created
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.setSerializationInclusion(Include.NON_EMPTY);
		
		String personAsString=mapper.writeValueAsString(person);
		System.out.println(personAsString);
		
		//.writerWithDefaultPrettyPrinter()   this is use to increase the readability of an object either we can use of this or INDENT_OUTPUT.
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/person.json"), person);
	}
}
