package lk.ijse.royalinstitute.controller;

import lk.ijse.royalinstitute.model.Course;
import lk.ijse.royalinstitute.model.Student;
import lk.ijse.royalinstitute.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateViewStudentController {
    public List<Student> getStudents() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List<Student> list = session.createNativeQuery("SELECT * FROM student", Student.class).list();

        transaction.commit();
        return list;
    }
}
