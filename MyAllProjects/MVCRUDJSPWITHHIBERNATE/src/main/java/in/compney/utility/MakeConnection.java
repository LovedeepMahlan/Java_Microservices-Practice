package in.compney.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import in.compney.dataObjects.StudentBO;

public class MakeConnection {
	private static SessionFactory factory;
	private static Session session;
	static {
		factory=new Configuration().configure().addAnnotatedClass(StudentBO.class).buildSessionFactory();
	}
	public static Session getSession() {
		if(factory!=null) {
			session=factory.openSession();
		}
		return session;
	}
	public static void closeConnections() {
		
		if(session!=null) {
			session.close();
		}
	}
}
