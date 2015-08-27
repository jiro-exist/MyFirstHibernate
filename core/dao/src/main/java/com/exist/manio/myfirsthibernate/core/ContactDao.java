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

    public void save(Contact contact) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            HibernateUtil.getCurrentSession().saveOrUpdate(contact);

            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            HibernateUtil.closeSession();
        }
    }

    public boolean delete(Contact contact) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            HibernateUtil.getCurrentSession().delete(contact);

            tx.commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }
        finally {
            HibernateUtil.closeSession();
        }
    }

    public List<Contact> queryContact() {
        List<Contact> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Contact.class);

        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<Contact> queryContact(String columnName, String sortOrder) {
        List<Contact> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Contact.class);
        switch (sortOrder) {

            case "asc"  :   cr.addOrder(Order.asc(columnName));
                            break;

            case "desc" :   cr.addOrder(Order.desc(columnName));
                            break;

            default     :   break;

        }

        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<Contact> searchContact(String columnName, Object obj) {
        List<Contact> result = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Contact.class);

        cr.add(Restrictions.eq(columnName, obj));
        result = cr.list();
        session.close();

        return result;
    }

}