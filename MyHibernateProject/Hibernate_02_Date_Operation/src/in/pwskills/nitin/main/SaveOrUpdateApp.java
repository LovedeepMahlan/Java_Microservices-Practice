package in.pwskills.nitin.main;
import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.PersonInfo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.*;
public class SaveOrUpdateApp {
	private static Session session = null;
	static {
		session = UtilClass.getSession();
	}
	public static void main(String[] args) {
		Transaction transaction=null;
		PersonInfo personinfo=null;
		boolean flag=false;
		try {
			if(session!=null) {
				transaction=session.beginTransaction();
				personinfo=new PersonInfo();
				personinfo.setPname("Lovedeep");
				personinfo.setPaddr("Dadri");
				personinfo.setDom(LocalDate.of(2002, 06, 24));
				personinfo.setDob(LocalDateTime.of(1996, 06, 26, 12, 48));
				personinfo.setDoj(LocalTime.of(21, 30,45));
				session.saveOrUpdate(personinfo);
				flag=true;
			}
		}catch(HibernateException hie) {
			System.out.println("HibernateException has been occured");
			hie.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
			}else {
				transaction.rollback();
			}
			UtilClass.CloseSessionFactory();
			if(session!=null) {
				session.close();
			}
		}
	}
}
