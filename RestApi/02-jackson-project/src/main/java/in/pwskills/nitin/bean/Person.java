package in.pwskills.nitin.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import in.pwskills.nitin.deserialize.CustomDateDeSerialization;
import in.pwskills.nitin.serialize.CustomDateSerialization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//to set Order of output
@JsonPropertyOrder(value= {"orders","firstName","lastName"})
//to add rootName in JSON object
@JsonRootName("Person")
//to ignore email in JSON object
@JsonIgnoreProperties(value="emailId")
public class Person {

	@JsonProperty(value="First_Name")
	private String firstName;

	@JsonProperty(value="Last_Name")
	private String lastName;

	private String emailId;

	@JsonSerialize(using=CustomDateSerialization.class)
	@JsonDeserialize(using=CustomDateDeSerialization.class)
	private Date dob;

	// HAS-A order:: multiple orders
	private List<Order> orders;

	// HAS-A account
	private Account account;

}
