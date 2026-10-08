package in.pwskills.nitin.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.pwskills.nitin.bean.CardPayment;
import in.pwskills.nitin.bean.Chequepayment;
import in.pwskills.nitin.bean.Payment;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static Session session = null;

	static {
		if (sessionFactory == null) {
			sessionFactory = new Configuration()
							.configure()
							.addAnnotatedClass(Payment.class)
							.addAnnotatedClass(Chequepayment.class)
							.addAnnotatedClass(CardPayment.class)
							.buildSessionFactory();
		}
	}

	public static Session getSession() {
		if (sessionFactory != null) {
			session = sessionFactory.openSession();
		}
		return session;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
	public static void closeSession(Session session) {
		if (session != null) {
			session.close();
		}
	}
}
