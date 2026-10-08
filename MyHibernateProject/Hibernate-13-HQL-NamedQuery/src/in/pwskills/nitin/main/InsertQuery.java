package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.nitin.util.HibernateUtil;
public class InsertQuery {

	private static final String Hibernate_Query= "INSERT INTO in.pwskills.nitin.bean."
            + "PremiumInsurancePolicy(policyId, policyName, policyType, company, tenure) SELECT i.policyId, i.policyName, "
            + "i.policyType, i.company, i.tenure FROM in.pwskills.nitin.bean.InsurancePolicy AS i WHERE i.tenure >= :min";
	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		boolean flag=false;
		String msg=null;
		int mintenure=5;
		int count=0;
		@SuppressWarnings("rawtypes")
		Query query=null;
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
				query=session.createQuery(Hibernate_Query);
				query.setParameter("min", mintenure);
				count=query.executeUpdate();
				flag=true;
			}
		}catch(HibernateException hie) {
			hie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {

			if (flag) {
				transaction.commit();
				msg = "No of records copied are :: " + count;
			} else {
				transaction.rollback();
				msg = "Records not copied/inserted";
			}

			HibernateUtil.closeSessionFactory();
			if (session != null) {
				session.close();
			}
		}

		System.out.println(msg);
	}
}
