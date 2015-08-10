package com.exist.manio.myfirsthibernate.core.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = createSession();

    private static final SessionFactory createSession() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable e) {
            System.out.println("Session factory initialization failed!");
            throw new ExceptionInInitializerError(e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void closeSessionFactory() {
        getSessionFactory().close();
    }

}