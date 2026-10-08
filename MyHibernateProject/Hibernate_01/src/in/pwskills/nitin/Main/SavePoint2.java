package in.pwskills.nitin.Main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.Student;

public class SavePoint2 {
	public static void main(String[] args) {
		Transaction transetion = null;
		Session session = null;
		boolean flag = false;
		try {
			session = UtilClass.getSession();
			if (session != null)
				transetion = session.beginTransaction();
			if (transetion != null) {
				Student student = new Student();
				student.setSname("Samson");
				student.setSaddress("RR");
				student.setSage(34);
				session.save(student);// it returns serializable object
				// session.persist(student); does not return anything
				flag = true;
			}
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			try {
				if(transetion!=null) {
					if (flag) {
						System.in.read();
						transetion.commit();
					} else {
						transetion.rollback();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			UtilClass.CloseSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}

}
