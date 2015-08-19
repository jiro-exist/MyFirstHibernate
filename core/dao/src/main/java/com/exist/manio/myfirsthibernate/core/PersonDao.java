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
import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Address;

public class PersonDao {

    public PersonDao() {
    }

    public void add(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        session.save(person);
        t.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();

        session.update(person);
        t.commit();

        session.close();
    }

    public boolean delete(int id) {
        boolean result = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Object persistentInstance = session.load(Person.class, id);

        if (persistentInstance != null) {
            session.delete(persistentInstance);
            t.commit();
            result = true;
        }

        session.close();
        return result;
    }

    public List<Person> queryPerson() {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Person.class);

        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<Person> queryPerson(String columnName, String sortOrder) {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Person.class);
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

    public List<Person> searchPerson(String columnName, int id) {
        List<Person> result = new ArrayList<>();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Person.class);

        cr.add(Restrictions.eq(columnName, id));
        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<Person> searchPerson(String columnName, String searchString) {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Person.class);

        cr.add(Restrictions.ilike(columnName,searchString));
        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<Person> searchPerson(String columnName, Double searchDouble) {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Person.class);

        cr.add(Restrictions.ilike(columnName,searchDouble));
        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<Person> searchPerson(String columnName, Date date) {
        List<Person> result = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Person.class);

        cr.add(Restrictions.eq(columnName,formatter.format(date)));
        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

}