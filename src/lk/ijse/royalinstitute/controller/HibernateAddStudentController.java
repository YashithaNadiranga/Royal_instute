package lk.ijse.royalinstitute.controller;

import lk.ijse.royalinstitute.model.Course;
import lk.ijse.royalinstitute.model.Registration;
import lk.ijse.royalinstitute.model.Student;
import lk.ijse.royalinstitute.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class HibernateAddStudentController {

    public void saveStudent(Student s) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        session.save(s);

        transaction.commit();
        session.close();
//        sessionFactory.close();

    }

    public List loadCid() {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


        List list = session.createNativeQuery("select code from course ").list();

        transaction.commit();
//        session.close();
//        sessionFactory.close();

        return list;

    }

    public void saveRegistrations(Registration r) {

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();



        session.save(r);

        transaction.commit();
//        session.close();
//        sessionFactory.close();
    }

    public void registretion(Registration r, String course) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Course course1 = session.get(Course.class, course);
        r.setCourse(course1);
        session.save(r);


        transaction.commit();
        session.close();
    }
}
