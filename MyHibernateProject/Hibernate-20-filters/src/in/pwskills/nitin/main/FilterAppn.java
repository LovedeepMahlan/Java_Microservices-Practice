package in.pwskills.nitin.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Filter;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.Project;
import in.pwskills.nitin.util.HibernateUtil;

public class FilterAppn {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		try {
			
			session = HibernateUtil.getSession();
			
			//enable of Filter without enabling we cant use filters
			Filter filter=session.enableFilter("SelectFilter");
			filter.setParameter("param1","Tech Innovators");
			
		

			Query<Project> query=session.createQuery("FROM Project WHERE teamSize>=:param");
			query.setParameter("param", 10);
			List<Project> list=query.getResultList();
			list.forEach(System.out::println);
			System.out.println();
			//Disabling of Filter
			session.disableFilter("SelectFilter");
			Query<Project> query1=session.createQuery("FROM Project WHERE teamSize>=:param");
			query1.setParameter("param", 10);
			List<Project> list1=query1.getResultList();
			list1.forEach(System.out::println);			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			
			HibernateUtil.closeSessionFactory();
			session.close();
			
		}

	}

}



