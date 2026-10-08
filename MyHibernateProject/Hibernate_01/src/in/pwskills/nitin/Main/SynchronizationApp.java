package in.pwskills.nitin.Main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.Student;

public class SynchronizationApp {
	public static void main(String[] args) {
		Session session=null;
		Student student=null;
		Transaction transaction=null;
		boolean flag=false;
		try {
			session=UtilClass.getSession();
			student=session.get(Student.class, 3);
			System.out.println("Student before updation is :: "+student);
			if(student!=null) {
				transaction=session.beginTransaction();
				student.setSname("Raina");
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(transaction!=null) {
				if(flag) {
					transaction.commit();
					System.out.println("Student after updation is :: "+student);
				}else {
					transaction.rollback();
				}
			}
			UtilClass.CloseSessionFactory();
			if(session!=null) {
				session.close();
			}
		}
	}
}
