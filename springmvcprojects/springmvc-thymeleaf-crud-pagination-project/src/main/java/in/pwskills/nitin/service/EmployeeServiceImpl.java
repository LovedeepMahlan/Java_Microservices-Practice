package in.pwskills.nitin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Employee> displayAllRecord(Pageable pageable) {
		
		return repo.findAll(pageable);
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
