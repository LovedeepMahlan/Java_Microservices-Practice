package in.pwskills.nitin.Javautil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.pwskills.nitin.bean.ProgrammerProjectInfo;
import in.pwskills.nitin.bean.Student;


public class UtilClass {
	private static SessionFactory sessionfactory=null;
	private static Session session=null;
	static {
		sessionfactory=new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
	}
	public static Session getSession() {
		if(sessionfactory!=null) {
			session=sessionfactory.openSession();
		}
		return session;
	}
	public static void CloseSessionFactory() {
		if(sessionfactory!=null) {
			sessionfactory.close();
		}
	}
}
