package in.pwskills.nitin.main;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.Project;
import in.pwskills.nitin.util.HibernateUtil;

public class QBCScalarApp {

	public static void main(String[] args) {
		Session session = null;


		try {
			// select projName from project where cost between(?,?) order by projName asc
			session = HibernateUtil.getSession();
			/*CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<String> cquery=builder.createQuery(String.class);
			Root<Project> root=cquery.from(Project.class);
			
			//write a query to print where cost between 15000,21000
			cquery.multiselect(root.get("projName")).
			where(builder.and(builder.between(root.get("cost"), 15000, 21000))).
			orderBy(builder.asc(root.get("projName")));
			
			Query<Long> query=session.createQuery(cquery);
			List<String> list = query.getResultList();
			list.forEach(System.out::println);*/
			
			//to print count(*)
			
			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaQuery<Long> cquery=builder.createQuery(Long.class);
			Root<Project> root=cquery.from(Project.class);
			
			cquery.multiselect(builder.count(root.get("projId")));
			Query<Long> query = session.createQuery(cquery);
			Optional<Long> optional = query.uniqueResultOptional();
			long count = optional.isPresent() ? optional.get() : 0;
			System.out.println("No of records is :: " + count);
			
			
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
			if(session!=null) {
				session.close();
			}
		}
}
}