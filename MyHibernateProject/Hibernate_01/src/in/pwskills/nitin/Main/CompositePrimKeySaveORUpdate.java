package in.pwskills.nitin.Main;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import in.pwskills.nitin.Javautil.UtilClass;
import in.pwskills.nitin.bean.ProgramProjID;
import in.pwskills.nitin.bean.ProgrammerProjectInfo;

public class CompositePrimKeySaveORUpdate {
	private static Session session=null;
	static {
		session=UtilClass.getSession();
	}
	public static void main(String[] args) {
		Transaction transection=null;
		ProgrammerProjectInfo info=null;
		ProgramProjID id=null;
		boolean flag=false;
		try {
			if(session!=null) {
				transection=session.beginTransaction();
				info=new ProgrammerProjectInfo();
				id=new ProgramProjID();
				id.setProgid(12);
				id.setProjid(21);
				info.setId(id);
				info.setProgrammerName("Lovedeep");
				info.setProjectName("Web DEvelopment");
				session.save(info);
				flag=true;
			}
		}catch(HibernateException he) {
			System.out.println("Some Hibernate Exception has been occured");
			he.printStackTrace();
		}catch(Exception e) {
			System.out.println("You are encountering an problem");
			e.printStackTrace();
		}finally {
			if(transection!=null) {
				if(flag) {
					transection.commit();
					System.out.println("Your data has been inserted");
				}else{
					transection.rollback();
					System.out.println("Sorry your transaction has been rollback due to some interruption");
				}
			}
		}
	}
}
