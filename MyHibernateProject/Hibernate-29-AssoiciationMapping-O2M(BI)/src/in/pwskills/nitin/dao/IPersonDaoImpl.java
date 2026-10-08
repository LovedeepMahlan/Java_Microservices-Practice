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

			Person person=new Person();
			person.setPname("Lovedeep");
			person.setPaddress("Charkhi Dadri");
			
			PhoneNumber phnno1=new PhoneNumber();
			phnno1.setMobileNo(123456789L);
			phnno1.setProvider("JIO");
			phnno1.setType("Personal");
			
			PhoneNumber phnno2=new PhoneNumber();
			phnno2.setMobileNo(7654321098L);
			phnno2.setProvider("Airtel");
			phnno2.setType("Office");
			
			person.setNumber(Set.of(phnno1,phnno2));
			
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
	public void addChildToExistingParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Person person=session.get(Person.class, 1);
			Set<PhoneNumber> number=person.getNumber();
			PhoneNumber no=new PhoneNumber();
			no.setMobileNo(8765457845L);
			no.setProvider("VI");
			no.setType("LandLine");
			number.add(no);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("New child has been added to the existing database");
				} else {
					transaction.rollback();
					System.out.println("transaction has been roll backed becausse of some error");
				}
			}

		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingParent() {
		 

		Session session = null;
		try {
			session = HibernateUtil.getSession();
			Query<Person> query = session.createQuery("from Person");
			List<Person> parents = query.getResultList();
			parents.forEach(parent -> {
				System.out.println(parent);
				Set<PhoneNumber> childs = parent.getNumber();
				childs.forEach(child -> System.out.println(child));
				System.out.println();
			});
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSessionFactory();
			HibernateUtil.closeSessionFactory();

		}
	}

	@Override
	public void deleteAllChildsOfAParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Person person=session.get(Person.class, 1);
			Set<PhoneNumber> number=person.getNumber();
			number.removeAll(number);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("All child data has been deleted");
				} else {
					transaction.rollback();
					System.out.println("transaction has been roll backed becausse of some error");
				}
			}

		}
		
		
	}

	@Override
	public void deleteOneChildFromCollectionofChildsOfAParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Person person=session.get(Person.class, 1);
			Set<PhoneNumber> number=person.getNumber();

			PhoneNumber child=session.get(PhoneNumber.class, 3);
			number.remove(child);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Child data has been deleted");
				} else {
					transaction.rollback();
					System.out.println("transaction has been roll backed becausse of some error");
				}
			}

		}
		
	}

	@Override
	public void deleteParentAndItsChilds() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			Person person=session.get(Person.class, 1);
			session.delete(person);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Data has been deleted from child as well as parent");
				} else {
					transaction.rollback();
					System.out.println("transaction has been roll backed becausse of some error");
				}
			}

		}
		
	}

	

}
