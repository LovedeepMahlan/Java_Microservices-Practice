package in.pwskills.nitin.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.Person;
import in.pwskills.nitin.bean.PhoneNumber;
import in.pwskills.nitin.util.HibernateUtil;

public class IPersonDaoImpl implements IPersonDao{

	@Override
	public void saveRecordUsingParent() {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Creating a parent object
			Person person=new Person();
			person.setPname("Sachin");
			person.setPaddress("MI");
			
			PhoneNumber phnno=new PhoneNumber();
			phnno.setMobileNo(2345678761L);
			phnno.setProvider("BSNL");
			phnno.setType("Personal");
			
			PhoneNumber phnno2=new PhoneNumber();
			phnno2.setMobileNo(8766542761L);
			phnno2.setProvider("VI");
			phnno2.setType("Business");
			// saving parent object
			
			person.setNumber(Set.of(phnno,phnno2));
			
			phnno.setPerson(person);
			phnno2.setPerson(person);
			session.save(person);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent...");
				} else {
					transaction.rollback();
					System.out.println("Record not saved to database Some Problem...");
				}
			}

		}
		
	}

	@Override
	public void saveRecordUsingChild() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Creating a parent object
			Person person=new Person();
			person.setPname("Sachin");
			person.setPaddress("MI");
			
			PhoneNumber phnno=new PhoneNumber();
			phnno.setMobileNo(2345678761L);
			phnno.setProvider("BSNL");
			phnno.setType("Personal");
			
			PhoneNumber phnno2=new PhoneNumber();
			phnno2.setMobileNo(8766542761L);
			phnno2.setProvider("VI");
			phnno2.setType("Business");
			// saving parent object
			
			person.setNumber(Set.of(phnno,phnno2));
			
			phnno.setPerson(person);
			phnno2.setPerson(person);
			session.save(phnno);
			session.save(phnno2);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent...");
				} else {
					transaction.rollback();
					System.out.println("Record not saved to database Some Problem...");
				}
			}

		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingChild() {
		Session session=null;
	try {
		session = HibernateUtil.getSession();

		Query<PhoneNumber> number=session.createQuery("from PhoneNumber");
		List<PhoneNumber> list=number.getResultList();
		
		list.forEach(child->{
			System.out.println(child);
			Person person=child.getPerson();
			System.out.println(person);
		});

	} catch (HibernateException he) {
		he.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		HibernateUtil.closeSession(session);
		HibernateUtil.closeSessionFactory();
	}

		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingParent() {
		Session session=null;
		try {
			session = HibernateUtil.getSession();

			Query<Person> number=session.createQuery("from Person");
			List<Person> list=number.getResultList();
			
			list.forEach(person->{
				System.out.println(person);
				Set<PhoneNumber> childs = person.getNumber();
				childs.forEach(System.out::println);
			});

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
