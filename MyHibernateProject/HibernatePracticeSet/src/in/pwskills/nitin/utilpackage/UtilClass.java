package in.pwskills.nitin.utilpackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import in.pwskills.nitin.Entity.Beginners;

public class UtilClass {

	private static SessionFactory factory;
	private static Session session;
	
	static {
		factory= new Configuration().configure().addAnnotatedClass(Beginners.class).buildSessionFactory();
	}
	
	public static Session getsesion() {
		if(factory!=null) {
			session=factory.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		if(session!=null) {
		factory.close();
			session.close();
			
		}
	}
}
