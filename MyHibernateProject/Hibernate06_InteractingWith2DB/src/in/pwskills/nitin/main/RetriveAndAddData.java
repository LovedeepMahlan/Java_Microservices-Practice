package in.pwskills.nitin.main;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.Product;
import in.pwskills.nitin.util.AppleHibernateUtil;
import in.pwskills.nitin.util.PwskillsHibernateUtil;

public class RetriveAndAddData {
	private static Session pwsession,applesession=null;
	
	static {
		applesession=AppleHibernateUtil.getSession();
		pwsession=PwskillsHibernateUtil.getSession();
	}
	public static void main(String[] args) {
		Transaction transaction=null;
		Product product=null;
		Scanner sc=null;
		boolean flag=false;
		try {
			if(pwsession!=null) {
				sc=new Scanner(System.in);
				int id=sc.nextInt();
				product=pwsession.get(Product.class,id);
			}
			if(product!=null) {
				if(applesession!=null) {
				transaction=applesession.beginTransaction();
				applesession.save(product);
				flag=true;
				}
			}
		}catch(HibernateException hie) {
			hie.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			PwskillsHibernateUtil.closeSessionFactory();
			if(pwsession!=null) {
				pwsession.close();
			}
			AppleHibernateUtil.closeSessionFactory();
			if(applesession!=null) {
				applesession.close();
			}
		}
	}
}
