package in.pwskills.nitin.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.pwskills.nitin.bean.Doctor;
import in.pwskills.nitin.bean.Patient;
import in.pwskills.nitin.util.HibernateUtil;

public class Hospital implements DoctorAndPatientDAO {

	
	@Override
	public void saveRecordUsingParent() {
		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Doctor d1=new Doctor();
			d1.setDoctName("Ravi Choudhary");
			d1.setHospital("PVC");
			
			Doctor d2=new Doctor();
			d2.setDoctName("Alka Choudhary");
			d2.setHospital("Birla");

			Doctor d3=new Doctor();
			d3.setDoctName("Sachin Choudhary");
			d3.setHospital("Oscar");
			
			Patient p1=new Patient();
			p1.setPatName("Ashish");
			p1.setProblem("Migrain");
			
			Patient p2=new  Patient();
			p2.setPatName("Rohit");
			p2.setProblem("Heart");
			
			Patient p3=new Patient();
			p3.setPatName("Vijay");
			p3.setProblem("Fiver");
			
			d1.setPatient(Set.of(p1,p2));
			d2.setPatient(Set.of(p3,p2));
			d3.setPatient(Set.of(p1,p3));
			
			p1.setDoctor(Set.of(d1,d2));
			p2.setDoctor(Set.of(d1,d3));
			p3.setDoctor(Set.of(d3,d2));
			
			session.save(d1);
			session.save(d2);
			session.save(d3);
			
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent(Doctors)...");
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
			
			Doctor d1=new Doctor();
			d1.setDoctName("Ravi Choudhary");
			d1.setHospital("PVC");
			
			Doctor d2=new Doctor();
			d2.setDoctName("Alka Choudhary");
			d2.setHospital("Birla");

			Doctor d3=new Doctor();
			d3.setDoctName("Sachin Choudhary");
			d3.setHospital("Oscar");
			
			Patient p1=new Patient();
			p1.setPatName("Ashish");
			p1.setProblem("Migrain");
			
			Patient p2=new  Patient();
			p2.setPatName("Rohit");
			p2.setProblem("Heart");
			
			Patient p3=new Patient();
			p3.setPatName("Vijay");
			p3.setProblem("Fiver");
			
			d1.setPatient(Set.of(p1,p2));
			d2.setPatient(Set.of(p3,p2));
			d3.setPatient(Set.of(p1,p3));
			
			p1.setDoctor(Set.of(d1,d2));
			p2.setDoctor(Set.of(d1,d3));
			p3.setDoctor(Set.of(d3,d2));
			
			session.save(p1);
			session.save(p2);
			session.save(p3);
			
			flag = true;

		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					System.out.println("Record saved to database using Parent(Doctors)...");
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
		Session session=HibernateUtil.getSession();
		Query<Doctor> query=session.createQuery("from Doctor");
		List<Doctor> list=query.getResultList();
		list.forEach(doctor->{
			System.out.println(doctor);
			Set<Patient> patient=doctor.getPatient();
			patient.forEach(System.out::println);
		});

	}

	@SuppressWarnings("unchecked")
	@Override
	public void loadRecordUsingChild() {
		Session session=HibernateUtil.getSession();
		Query<Patient> query=session.createQuery("from Patient",Patient.class);
		List<Patient> list=query.getResultList();
		list.forEach(patient->{
			System.out.println(patient);
			Set<Doctor> doctor=patient.getDoctor();
			doctor.forEach(System.out::println);
		});

	}

}
