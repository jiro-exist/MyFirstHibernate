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

    public List<Person> queryPerson() {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);

        result = cr.list();
        session.close();

        return result;
    }

    public List<Person> queryPerson(String columnName, String sortOrder) {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);
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

    public List<Person> searchPerson(String columnName, String searchString) {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);

        cr.add(Restrictions.ilike(columnName,searchString));
        result = cr.list();
        session.close();

        return result;
    }

    public List<Person> searchPerson(String columnName, Double searchDouble) {
        List<Person> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);

        cr.add(Restrictions.ilike(columnName,searchDouble));
        result = cr.list();
        session.close();

        return result;
    }

    public List<Person> searchPerson(String columnName, Date date) {
        List<Person> result = new ArrayList<>();

        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);

        cr.add(Restrictions.eq(columnName,formatter.format(date)));
        result = cr.list();
        session.close();

        return result;
    }

}