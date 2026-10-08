 package in.pwskills.nitin.main;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import in.pwskills.nitin.bean.InsurancePolicy;
import in.pwskills.nitin.util.HibernateUtil;

public class NativeSql {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Session session=HibernateUtil.getSession();
		try {
		NativeQuery<InsurancePolicy> query=session.createSQLQuery("SELECT * FROM insurancepolicy WHERE tenure>=:min and tenure<=:max");
		query.setParameter("min", 6);
		query.setParameter("max", 12);
		query.addEntity(InsurancePolicy.class);
		List<InsurancePolicy> list =query.getResultList();
		list.forEach(System.out::println);
		
		System.out.println("*************************************");
		//select by without mappping
		NativeQuery<Object[]> query1=session.createSQLQuery("SELECT * FROM insurancepolicy WHERE tenure>=:min and tenure<=:max");
		query1.setParameter("min", 6);
		query1.setParameter("max", 12);
		List<Object[]> lst=query1.getResultList();
		lst.forEach(entity->{
			for(Object obj:entity) {
				System.out.print(obj+" ");
			}
			System.out.println();
		});
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
