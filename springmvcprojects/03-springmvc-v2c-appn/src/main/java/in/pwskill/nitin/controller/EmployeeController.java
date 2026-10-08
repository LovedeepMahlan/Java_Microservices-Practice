package in.pwskill.nitin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.pwskills.nitin.beans.Employee;

@Controller()
@RequestMapping(value="/employee")
public class EmployeeController {

	/*** 
	 *    DISPLAY THE FORM
	 * 1. METHOD TYPE :: GET
	 * 2. PATH        :: /show
	 * 3. R.T         :: Employee.jsp
	 */
	@GetMapping(value="/show")
	public String showEmployee() {
		return "Employee";
	}

	@PostMapping(value="/save")
	public String saveData(@ModelAttribute
							Employee employee,
							Model model) {
		
		model.addAttribute("employee",employee);
		return "EmpPage";
	}
}
