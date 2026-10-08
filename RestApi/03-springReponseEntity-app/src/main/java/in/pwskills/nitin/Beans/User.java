package in.pwskills.nitin.Beans;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@JsonIgnore
	Integer id;
	@JsonProperty(value = "User_Name")
	String name;
	List<String> friends;
	Map<String, Integer> accDetails;
	
}
