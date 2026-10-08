package in.pwskills.nitin.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.Naukri;
import in.pwskills.nitin.util.HibernateUtil;

public class SaveOrUpdate {

	public static void main(String[] args) {
		Session session=null;
		Transaction transaction=null;
		char[] resume=null;
		byte[] image=null;
		FileInputStream fis=null;
		BufferedReader br=null;
		Naukri naukri=null;
		boolean flag=false;
		try {
			String path="C:\\Users\\Xps\\OneDrive\\Pictures\\Camera Roll\\WIN_20240401_22_42_29_Pro.jpg";
			fis=new FileInputStream(path);
			image=new byte[fis.available()];
			fis.read(image);
			File file=new File("D:\\src\\resume.txt");
			br=new BufferedReader(new FileReader(file));
			resume=new char[(int)file.length()];
			br.read(resume);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			session=HibernateUtil.getSession();
			if(session!=null) {
				transaction=session.beginTransaction();
				naukri=new Naukri();
				naukri.setAddress("Chandigargh");
				naukri.setImage(image);
				naukri.setName("Rohit");
				naukri.setResume(resume);
				session.saveOrUpdate(naukri);
				flag=true;
				
			}
		}catch(HibernateException hie) {
			hie.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {

			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record inserted/updated succesfully...");
				} else {
					transaction.rollback();
					System.out.println("Record failed for updation...");
				}

				HibernateUtil.closeSessionFactory();
				if (session != null) {
					session.close();
				}
			}
	}
	}}
