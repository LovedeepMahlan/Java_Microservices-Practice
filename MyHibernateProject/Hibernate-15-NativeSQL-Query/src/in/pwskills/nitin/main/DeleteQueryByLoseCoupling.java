package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.nitin.util.HibernateUtil;

public class DeleteQueryByLoseCoupling {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		boolean flag=false;
		int count=0;
		Transaction transaction=session.beginTransaction();
		try {
			Query nquery=session.createNamedQuery("DeleteQuery");
			nquery.setParameter("comp", "SBI");
			// running the query
			count = nquery.executeUpdate();
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("No of records deleted are :: " + count);

				} else {
					transaction.rollback();
					System.out.println("Some problem with insertion of records....");
				}
			}

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}
	}

}
