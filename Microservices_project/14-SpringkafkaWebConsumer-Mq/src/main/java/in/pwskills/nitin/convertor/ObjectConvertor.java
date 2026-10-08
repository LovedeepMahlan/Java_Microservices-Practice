package in.pwskills.nitin.convertor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import in.pwskills.nitin.bean.StockApi;

public class ObjectConvertor {

	public static StockApi JsontoJava(String obj) {
		
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			return mapper.readValue(obj, StockApi.class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
