package in.pwskills.nitin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.pwskills.nitin.beans.Employee;
import in.pwskills.nitin.repository.IEmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	IEmployeeRepo repo;
	
	@Override
	public void saveRecord(Employee employee) {
		repo.save(employee);
		
	}

	@Override
	public List<Employee> displayAllRecord() {
		List<Employee> empList =repo.findAllByOrderByLastNameAsc();
		
		return empList;
	}

	@Override
	public void deleteRecord(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public Employee findEmployee(Integer id) {
		Employee emp=repo.findById(id).get();
		return emp;
	}

	

	
}
