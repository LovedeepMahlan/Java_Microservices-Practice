package in.pwskills.nitin.main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.MobileCustomer;
import in.pwskills.nitin.util.HibernateUtil;

public class SaveOrUpdate {
	private static Session session=null;
	static {
		session=HibernateUtil.getSession();
	}
	public static void main(String[] args) {
		Transaction transaction=null;
		MobileCustomer customer=null;
		boolean flag=false;
		try {
			if(session!=null) {
				transaction=session.beginTransaction();
				customer=new MobileCustomer();
				customer.setCallerTune("Tune...Tune...");
				customer.setCname("Chawla");
				customer.setCno(234);
				customer.setMobileNo(1234567890l);
				session.saveOrUpdate(customer);
				flag=true;
				
			}
		}catch(HibernateException hie) {
			hie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			HibernateUtil.closeSessionFactory();
			if(session!=null) {
				session.close();
			}
		}
	}
}
