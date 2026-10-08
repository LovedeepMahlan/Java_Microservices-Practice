package in.pwskills.nitin.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	//used for unuse from json
	@JsonIgnore
	private int id;
	private String name;
	private List<String> friends;
	private Address address;
}
