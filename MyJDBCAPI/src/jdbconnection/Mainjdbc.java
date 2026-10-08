package jdbconnection;

import java.sql.SQLException;
import java.util.Scanner;

import com.jdbc.DTO.Student;
import com.jdbc.controller.IStudentController;
import com.jdbc.factoryrepo.StudentControllerFctory;

public class Mainjdbc {
public static void main(String[] args) {
	IStudentController controller=StudentControllerFctory.getStudentController();
	Student stud=new Student();
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter thr sid");
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
		controller.insertRecord(stud);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("Sorry You are unable to insert the record");
		e.printStackTrace();
	}
 }
}
