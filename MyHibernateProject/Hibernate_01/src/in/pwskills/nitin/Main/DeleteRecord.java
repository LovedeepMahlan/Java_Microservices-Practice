package in.pwskills.nitin.Main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.Student;

public class DeleteRecord {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		
		Integer id=1;
		boolean flag=false;
		Student student=null;
		try {
			session=UtilClass.getSession();
			student =session.load(Student.class, id);
			System.out.println(student);
			if(session!=null) {
				transaction=session.beginTransaction();
				session.delete(student);
				flag=true;
			}
		}catch(HibernateException hb) {
			hb.printStackTrace();
		}finally {
			if(transaction!=null) {
				if(flag=true) {
					transaction.commit();
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
