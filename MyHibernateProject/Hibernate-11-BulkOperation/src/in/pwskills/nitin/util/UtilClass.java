package in.pwskills.nitin.util;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


import in.pwskills.nitin.bean.InsurancePolicy;

public class UtilClass {
private static Session session=null;
private static org.hibernate.SessionFactory sessionfactory=null;
	static {
		sessionfactory=new Configuration().configure().addAnnotatedClass(InsurancePolicy.class).buildSessionFactory();
	}
	public static Session getSession() {
		if(sessionfactory!=null) {
			session=sessionfactory.openSession();
		}
		return session;
	}
	public static void closefactory() {
		if(sessionfactory!=null) {
			sessionfactory.close();
		}
	}
}
