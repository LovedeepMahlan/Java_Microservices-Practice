package in.pwskills.nitin.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Employee {

	private Integer empId;
	private String empName;
	private Double empSalary;

	private String empPassword;
	private String empDepartment;
	private String empAddress;
}
