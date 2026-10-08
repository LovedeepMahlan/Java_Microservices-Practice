package in.pwskills.nitin.dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.LiberaryMembership;
import in.pwskills.nitin.bean.Student;
import in.pwskills.nitin.util.HibernateUtil;

public class StudentInterfImpl implements StudentInterf{

	@Override
	public void saveRecordUsingParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();

			// Create parent object(Student)
			Student student = new Student();
			student.setSname("rajashree");
			student.setSaddress("Chennai");

			//Create LiberaryMembership Object
			LiberaryMembership mem=new LiberaryMembership();
			mem.setType("Monthly");
			mem.setDate(LocalDate.of(2023, 04, 02));
			
			student.setLibmem(mem);
			mem.setStudent(student);
			session.save(student);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent(Student)...");
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

			// Create parent object(Student)
			Student student = new Student();
			student.setSname("Alok");
			student.setSaddress("Palwal");

			//Create LiberaryMembership Object
			LiberaryMembership mem=new LiberaryMembership();
			mem.setType("Quaterly");
			mem.setDate(LocalDate.of(2024, 12, 26));
			
			student.setLibmem(mem);
			mem.setStudent(student);
			session.save(mem);
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent(Student)...");
				} else {
					transaction.rollback();
					System.out.println("Record not saved to database Some Problem...");
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

			Query<Student> query = session.createQuery("from Student");
			List<Student> records = query.getResultList();
			System.out.println();
			records.forEach(row -> {
				System.out.println(row);
				LiberaryMembership libraryMembership = row.getLibmem();
				System.out.println(libraryMembership);
				System.out.println();
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
