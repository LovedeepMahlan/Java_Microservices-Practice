



package in.pwskills.nitin.main;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.From;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.Project;
import in.pwskills.nitin.util.HibernateUtil;

public class Updatetion {


	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session = null;
		Transaction transaction = null;
		boolean flag= false;
		long count = 0;

		try {
			//delete from project where cost between(27000 , 45000)
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			CriteriaBuilder builder=session.getCriteriaBuilder();
			CriteriaUpdate<Project> cQuery=builder.createCriteriaUpdate(Project.class);
			Root<Project> root=cQuery.from(Project.class);
			cQuery.set(root.get("teamSize"),20)
		      .set(root.get("location"), "hyd")
		      .where(builder.ge(root.get("cost"), 25000));
			
			Query<Integer> query=session.createQuery(cQuery);
			count=query.executeUpdate();
		} catch (HibernateException he) {
			he.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records deleted is :: "+count);
			} else {
				transaction.rollback();
				System.out.println("No records found to delete");
			}
			
			HibernateUtil.closeSessionFactory();
			
		}

	}

}



