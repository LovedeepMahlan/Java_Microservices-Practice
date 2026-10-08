package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import in.pwskills.nitin.util.HibernateUtil;

public class NativeSqlInsertQuery {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		boolean flag=false;
		int count=0;
		Transaction transaction=session.beginTransaction();
		try {
			NativeQuery nquery=session.createSQLQuery("insert into insurance_policy(`pcompany`,`pname`,`ptype`,`ptenure`) values(:comp,:pname,:ptype,:tenure)");
			//native sql query is generated with database table and its column name not with Entity.
			nquery.setParameter("comp", "tata");
			nquery.setParameter("pname", "healtVIG");
			nquery.setParameter("ptype", "montly");
			nquery.setParameter("tenure", "35");

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
					System.out.println("No of records inserted are :: " + count);

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
