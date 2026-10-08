package in.pwskills.nitin.Main;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.ProgramProjID;
import in.pwskills.nitin.bean.ProgrammerProjectInfo;

public class GetRecordOfCompositePrimary {
	private static Session session=null;
	
	static {
		session=UtilClass.getSession();
	}
	public static void main(String[] args) {
		ProgrammerProjectInfo info=null;
		ProgramProjID id=null;
		try {
			if(session!=null) {
				id=new ProgramProjID();
				id.setProgid(101);
				id.setProjid(21);
				info=session.get(ProgrammerProjectInfo.class,id);
				if(info!=null) {
					System.out.println("Your project detaisa is ::"+info);
				}else {
					System.out.println("Your project is not existing with given id");
				}
			}
		}catch(HibernateException hie) {
			System.out.println("HibernateException occurs");
			hie.printStackTrace();
		}catch(Exception e) {
			System.out.println("Some error has been occured");
			e.printStackTrace();
		}finally {
			UtilClass.CloseSessionFactory();
			if(session!=null) {
				session.close();
			}
		}
	}

}
