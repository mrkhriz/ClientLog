package co.com.client;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import java.io.File;

/**
 * Created by User on 28/05/2020.
 */
public class HibernateFactory {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure(new File(HibernateFactory.class.getClassLoader().getResource("hibernate.cfg.xml").getFile())).buildSessionFactory();

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}