package com.exist.manio.myfirsthibernate.core.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Order;

import com.exist.manio.myfirsthibernate.core.dao.HibernateUtil;
import com.exist.manio.myfirsthibernate.core.model.Contact;

public class ContactDao {

    public ContactDao() {
    }

    public void add(Contact contact) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        session.save(contact);
        t.commit();
        session.close();
    }

    public void update(Contact contact) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        session.update(contact);
        t.commit();

        session.close();
    }

    public boolean delete(int id) {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Object persistentInstance = session.load(Contact.class, id);

        if (persistentInstance != null) {
            session.delete(persistentInstance);
            t.commit();
            result = true;
        }

        session.close();
        return result;
    }

    public List<Contact> queryContact() {
        List<Contact> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Contact.class);

        result = cr.list();
        session.close();

        return result;
    }

    public List<Contact> queryContact(String columnName, String sortOrder) {
        List<Contact> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Contact.class);
        switch (sortOrder) {

            case "asc"  :   cr.addOrder(Order.asc(columnName));
                            break;

            case "desc" :   cr.addOrder(Order.desc(columnName));
                            break;

            default     :   break;

        }

        result = cr.list();
        session.close();

        return result;
    }

    public List<Contact> searchContact(String columnName, int id) {
        List<Contact> result = new ArrayList<>();
        System.out.println("1");
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("2");
        Criteria cr = session.createCriteria(Contact.class);
        System.out.println("3");

        cr.add(Restrictions.eq(columnName, id));
        System.out.println("4");
        result = cr.list();
        System.out.println("5");
        session.close();
        System.out.println("6");

        return result;
    }

    public List<Contact> searchContact(String columnName, String searchString) {
        List<Contact> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Contact.class);

        cr.add(Restrictions.ilike(columnName,searchString));
        result = cr.list();
        session.close();

        return result;
    }

    public List<Contact> searchContact(String columnName, Double searchDouble) {
        List<Contact> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Contact.class);

        cr.add(Restrictions.ilike(columnName,searchDouble));
        result = cr.list();
        session.close();

        return result;
    }

    public List<Contact> searchContact(String columnName, Date date) {
        List<Contact> result = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Contact.class);

        cr.add(Restrictions.eq(columnName,formatter.format(date)));
        result = cr.list();
        session.close();

        return result;
    }

}