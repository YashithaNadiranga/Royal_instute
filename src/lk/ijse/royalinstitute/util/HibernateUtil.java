package lk.ijse.royalinstitute.util;

import lk.ijse.royalinstitute.model.Course;
import lk.ijse.royalinstitute.model.Registration;
import lk.ijse.royalinstitute.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry sReg = new StandardServiceRegistryBuilder().loadProperties("application.properties").build();
        Metadata build = new MetadataSources(sReg).addAnnotatedClass(Student.class).addAnnotatedClass(Registration.class)
                .addAnnotatedClass(Course.class).getMetadataBuilder().build();
        return build.getSessionFactoryBuilder().build();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

}
