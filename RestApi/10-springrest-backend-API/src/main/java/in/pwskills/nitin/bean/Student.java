package in.pwskills.nitin.bean;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Student_Table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer stdId;
	
	//@NotNull(message = "name can't be null")
	//@NotEmpty(message = "name can't be empty")
	@NotBlank
	@Size(min=2,max=15,message = "Name size can be 2 to 15")
	@Pattern(regexp = "[A-Z a-z]{2,15}",message = "Name can be of [A-Za-z] ")
	@Column(name="name")
	private String stdName;
	
	@NotBlank(message="std gender can't be blank")
	@Column(name="gender")
	private String stdGen;
	
	@Column(name="course")
	@NotBlank(message="course name can't be blank")
	private String stdCourse;
	
	@NotBlank(message="address can't be blank")
	@Pattern(regexp = "[A-Za-z#@/?\\.0-9]{2,50}",message="Invalid character range")
	@Column(name="address")
	private String stdAddr;
}
