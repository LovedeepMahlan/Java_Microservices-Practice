package in.pwskills.nitin;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskills.nitin.bean.Person;

public class Json2JavaApp {
	public static void main(String[] args) throws Exception {

		ObjectMapper mapper=new ObjectMapper();
		//to remove root value
		mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
		
		Person person=mapper.readValue("src/main/resources/person.json", Person.class);
		System.out.println(person);
	}
}
