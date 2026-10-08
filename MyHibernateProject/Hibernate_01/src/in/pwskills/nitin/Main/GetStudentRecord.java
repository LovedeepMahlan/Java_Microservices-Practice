package in.pwskills.nitin.Main;

import java.io.IOException;
import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.Student;

public class GetStudentRecord {

	public GetStudentRecord() {
		System.out.println("Zero Parameter Constructor of Student");
	}
	public static void main(String[] args) {
		Session session=null;
		Student student=null;
		Student student1=null;
		Student student2=null;
		Student student3=null;
		Student student4=null;
		Scanner sc=null;
		Integer Sid=null;
		
		try {
			session=UtilClass.getSession();
			sc=new Scanner(System.in);
			if(session!=null && sc!=null) {
				System.out.println("Enter the Sid...");
				Sid=sc.nextInt();
				student=session.get(Student.class,Sid);
			}
			if(student!=null) {
				System.in.read();
				System.out.println("Student Object Details are...");
				System.out.println("Sid="+student.getSid());
				System.out.println("Sname="+student.getSname());
				System.out.println("Sage="+student .getSage());
				System.out.println("Saddress="+student.getSaddress());
				
				student1=session.get(Student.class,3);
				session.clear();
				student2=session.get(Student.class,Sid);
				session.evict(student1);
				student3=session.get(Student.class,Sid);
				student4=session.get(Student.class,3);
				
				//one more method to get the data
				//session.load(student.class,5);
			}else {
				System.in.read();
				System.out.println("Student object not found for given Sid value");
			}
			
			
		}catch(HibernateException | IOException hie) {
			hie.printStackTrace();
		}
	}

}
