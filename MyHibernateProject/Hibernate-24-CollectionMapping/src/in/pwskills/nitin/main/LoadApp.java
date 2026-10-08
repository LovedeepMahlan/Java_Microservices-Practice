package in.pwskills.nitin.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.Employee;
import in.pwskills.nitin.util.HibernateUtil;

public class LoadApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		int id = 1;

		try {
			session = HibernateUtil.getSession();
			Query<Employee> query=session.createQuery("from Employee");
			List<Employee> list=query.getResultList();
			list.forEach(System.out::println);
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}
}
