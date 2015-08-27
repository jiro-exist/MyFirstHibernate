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
import com.exist.manio.myfirsthibernate.core.model.ContactType;

public class ContactTypeDao {

    public ContactTypeDao() {
    }

    public void save(ContactType contactType) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            HibernateUtil.getCurrentSession().saveOrUpdate(contactType);

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

    public boolean delete(ContactType contactType) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            HibernateUtil.getCurrentSession().delete(contactType);

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

    public List<ContactType> queryContactType() {
        List<ContactType> result = new ArrayList<>();
        System.out.println("contact_type");

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(ContactType.class);

        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<ContactType> queryContactType(String columnName, String sortOrder) {
        List<ContactType> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(ContactType.class);
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

    public List<ContactType> searchContactType(String columnName, Object obj) {
        List<ContactType> result = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(ContactType.class);

        cr.add(Restrictions.eq(columnName, obj));
        result = cr.list();
        session.close();

        return result;
    }

}