package in.pwskills.nitin.Main;

import org.hibernate.cfg.Configuration;
import in.pwskills.nitin.bean.Student;
import org.hibernate.*;

public class SavePoint {

    public SavePoint() {
        System.out.println("MainApp.MainApp()");
    }

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure();
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student student = new Student();

            student.setSname("Dube");
            student.setSage(46);
            student.setSaddress("CSK");
            session.save(student);
            transaction.commit();
            System.out.println("Student saved successfully");
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
