package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.InsurancePolicy;
import in.pwskills.nitin.util.UtilClass;

public class HQLUpdateQueryApp {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		long count = 0;
		try {

			session =UtilClass.getSession();
			transaction = session.beginTransaction();
			Query<InsurancePolicy> query = session.createQuery(
					"UPDATE in.pwskills.nitin.bean.InsurancePolicy SET tenure=tenure+:bonusyears WHERE policyName LIKE:initialLetters");

			// setting the parameter
			query.setParameter("bonusyears", 10);
			query.setParameter("initialLetters", "J%");

			// execute the query
			count = query.executeUpdate();
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} catch (Exception e) {
			e.printStackTrace();
			flag =false;
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("No of records updated are :: " + count);
			} else {
				transaction.rollback();
			}
			UtilClass.closefactory();
			if (session != null) {
				session.close();
			}
		}
	}
}
