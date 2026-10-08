package in.pwskills.nitin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.pwskills.nitin.beans.Employee;

public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {

}
