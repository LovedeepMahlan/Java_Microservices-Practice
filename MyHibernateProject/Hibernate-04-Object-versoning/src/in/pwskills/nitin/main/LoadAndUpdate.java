package in.pwskills.nitin.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.MobileCustomer;
import in.pwskills.nitin.util.HibernateUtil;

public class LoadAndUpdate {
	private static Session session=null;
	static {
		session=HibernateUtil.getSession();
	}
	public static void main(String[] args) {
		Transaction transaction=null;
		MobileCustomer customer=null;
		Scanner sc=new Scanner(System.in);
		boolean flag=false;
		try {
			int id=sc.nextInt();
			customer=session.get(MobileCustomer.class,id);
			if(customer!=null) {
				transaction=session.beginTransaction();
				customer.setCallerTune("Ohm Namash Shivya");
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
