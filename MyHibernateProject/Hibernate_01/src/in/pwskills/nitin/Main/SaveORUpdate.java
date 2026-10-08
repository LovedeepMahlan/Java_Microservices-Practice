package in.pwskills.nitin.Main;

import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.Student;

public class SaveORUpdate {

	public SaveORUpdate() {
		System.out.println("Zero argumnet Constructor...");
	}
	public static void main(String[] args) {
		Session session=null;
		Transaction transection=null;
		Student student=null;
		Scanner sc =null;
		Integer id=null;
		
		String name=null,age=null,address=null;
		boolean flag=false;
		try {
			sc=new Scanner(System.in);
			session=UtilClass.getSession();
			if(session!=null&&sc!=null) {
				System.out.println("Enter the value of id...");
				id=Integer.parseInt(sc.nextLine());
				student=session.get(Student.class, id);
			}
			if(student!=null) {
				transection=session.beginTransaction();
			
			if(transection!=null) {
				System.out.println("Student Record is ::"+id);
				System.out.println("Old name is :: "+student.getSname()+" Enter new name");
				name=sc.nextLine();
				if(name.equals("") || name==null) {
					student.setSname(student.getSname());
				}else {
					student.setSname(name);
				}
			
				System.out.println("Old age is :: "+student.getSage()+" Enter new age");
				age=sc.nextLine();
				if(age.equals("") || age==null) {
					student.setSage(student.getSage());
				}else {
					student.setSage(Integer.parseInt(age));
				}
				System.out.println("Old address is :: "+student.getSaddress()+" Enter new address");
				address=sc.nextLine();
				if(address.equals("") || address==null) {
					student.setSaddress(student.getSaddress());
				}else {
					student.setSaddress(address);
				}
				session.saveOrUpdate(student);
				flag=true;
			}	
		}else {
			student=new Student();
			student.setSname("Vikram");
			student.setSage(23);
			student.setSaddress("MUMBAI");
			transection=session.beginTransaction();
			session.saveOrUpdate(student);
			flag=true;
		}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag)
				transection.commit();
			else {
				transection.rollback();
			}
		}
	}

}
