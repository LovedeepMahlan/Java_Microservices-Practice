package jdbconnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DTO.Employee;
import com.jdbc.controller.IEmployeeControlller;
import com.jdbc.controller.IStudent2Controller;
import com.jdbc.factoryrepo.EmployeeControllerFactory;
import com.jdbc.factoryrepo.Student2ControllerFactory;
import com.jdbc.repository.EmployeeRepoImpl;
import com.jdbc.repository.IEmployeeRepo;

public class MainProject {
public static void main(String[] args) {
	IEmployeeControlller ies=EmployeeControllerFactory.GetEmployeeController();
	Employee employee=new Employee();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the eid");
	Integer eid=sc.nextInt();
	System.out.println("Enter the ename");
	String ename=sc.next();
	System.out.println("enter the eaddress");
	String eaddress=sc.next();
	System.out.println("Enter  the location");
	String elocation=sc.next();
	System.out.println("if you press 2 get Employee details or if press 1 then you can insert a Employee");
	int press=sc.nextInt();
	employee.setEaddress(eaddress);
	employee.setEid(eid);
	employee.setEname(ename);
	employee.setResume(elocation);
	employee.setLoction(elocation);
	System.out.println(employee.getLoction());
	try {
		if(press==1) {
		ies.insertEmployee(employee);
		}
		if(press==2) {
		ies.getEmployee(employee);
		}
	} catch ( SQLException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
