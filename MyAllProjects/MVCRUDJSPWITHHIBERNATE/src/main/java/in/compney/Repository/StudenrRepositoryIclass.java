package in.compney.Repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.compney.dataObjects.StudentBO;
import in.compney.utility.MakeConnection;

public class StudenrRepositoryIclass implements StudentRepository {
	
	@Override
	public String InsertRecord(StudentBO stdbo) {
		Transaction transaction=null;
		boolean flag=false;
		String status=null;
		Session session=null;
		try {
			session=MakeConnection.getSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(stdbo);
			flag=true;
		}catch(HibernateException hie){
			System.out.println("Some Hibernate has been occured");
			hie.printStackTrace();
		}finally {
			if(flag) {
				transaction.commit();
				status="success";
			}else {
				transaction.rollback();
				status="failure";
			}
			MakeConnection.closeConnections();
		}
		return status;
		}

	@Override
	public StudentBO readRecord(Integer sid) {
		StudentBO bo=null;
		Session session=null;
		try {
			session=MakeConnection.getSession();
			bo=session.get(StudentBO.class,sid);
		}catch(HibernateException hie) {
			hie.printStackTrace();
			System.out.println("some Hibernate Excepton has been occured");
		}finally {
			MakeConnection.closeConnections();
		}
		return bo;
	}

	@Override
	public String deleteRecord(Integer sid) {
		Transaction transaction=null;
		StudentBO bo=null;
		boolean flag=false;
		String status=null;
		Session session=null;
		try {
			session=MakeConnection.getSession();
			bo=readRecord(sid);
			transaction=session.beginTransaction();
			session.delete(bo);
			flag=true;
		}catch(HibernateException hie){
			hie.printStackTrace();
			System.out.println("Some HIE has been occured");
		}finally {
			if(flag) {
				transaction.commit();
				status="success";
			}else {
				transaction.rollback();
				status="failure";
			}
			MakeConnection.closeConnections();
		}
		return status;
	}

	@Override
	public String updateRecord(StudentBO stdbo) {
		Transaction transaction=null;
		boolean flag=false;
		String status=null;
		Session session=null;
		try {
			session=MakeConnection.getSession();
			transaction=session.beginTransaction();
			session.saveOrUpdate(stdbo);
			flag=true;
		}catch(HibernateException hie) {
			hie.printStackTrace();
			System.out.println("StudenrRepositoryIclass.updateRecord() is facing an HibernateExceptionerrror");
		}finally {
			if(flag) {
				if(transaction!=null) {
					transaction.commit();
				}
				status="success";
			}else {
				if(transaction!=null) {
					transaction.rollback();
				}
			}
			MakeConnection.closeConnections();
		}
		return status;
	}
}
