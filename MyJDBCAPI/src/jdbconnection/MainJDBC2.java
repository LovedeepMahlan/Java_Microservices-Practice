package jdbconnection;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DTO.Student2;
import com.jdbc.controller.IStudent2Controller;
import com.jdbc.factoryrepo.Student2ControllerFactory;

public class MainJDBC2 {
public static void main(String[] args) {
	IStudent2Controller is2=Student2ControllerFactory.getStudet2Controller();
	Student2 stud=new Student2();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the sid");
	Integer sid=sc.nextInt();
	System.out.println("Enter the Sname");
	String sname=sc.next();
	System.out.println("Enter the sadddress");
	String saddress=sc.next();
	System.out.println("Enter the sage");
	Integer sage=sc.nextInt();
	stud.setSid(sid);
	stud.setSaddress(saddress);
	stud.setSname(sname);
	stud.setSage(sage);
	try {
		is2.deleterecord(stud);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
