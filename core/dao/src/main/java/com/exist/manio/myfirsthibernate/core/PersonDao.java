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
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import com.exist.manio.myfirsthibernate.core.dao.HibernateUtil;
import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Address;

public class PersonDao {

    public PersonDao() {
    }

    public void save(Person person) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            HibernateUtil.getCurrentSession().saveOrUpdate(person);

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

    public boolean delete(Person person) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            HibernateUtil.getCurrentSession().delete(person);

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

    public List<Person> getPerson() {
        List<Person> result = new ArrayList<>();

        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();
            Criteria cr = HibernateUtil.getCurrentSession().createCriteria(Person.class);
                
            result = cr.list();
            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    public List<Person> getPerson(String columnName, String sortOrder) {
        List<Person> result = new ArrayList<>();

        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();
            Criteria cr = HibernateUtil.getCurrentSession().createCriteria(Person.class);

            switch (sortOrder) {

                case "asc"  :   cr.addOrder(Order.asc(columnName));
                                break;

                case "desc" :   cr.addOrder(Order.desc(columnName));
                                break;

                default     :   break;

            }
                
            result = cr.list();
            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            HibernateUtil.closeSession();
        }

        return result;
    }

    public List<Person> getPerson(String sortColumn, String sortOrder, String... columnName) {
        List<Person> result = new ArrayList<>();

        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();
            Criteria cr = HibernateUtil.getCurrentSession().createCriteria(Person.class);

            ProjectionList projList = Projections.projectionList();
            for(String column : columnName) {
                projList.add(Projections.property(column));
            }
            cr.setProjection(projList);
            // cr.addOrder(Order.asc(sortColumn));

            switch (sortOrder) {

                case "asc"  :   cr.addOrder(Order.asc(sortColumn));
                                break;

                case "desc" :   cr.addOrder(Order.desc(sortColumn));
                                break;

                default     :   break;

            }

            result = cr.list();
            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            HibernateUtil.closeSession();
        }

        return result;
    }

    public List<Person> queryPerson(String sqlString) {
        List<Person> result = new ArrayList<>();

        try {
            Transaction tx = HibernateUtil.beginTransaction();
            Query query = HibernateUtil.getCurrentSession().createQuery(sqlString);
            result = query.list();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            HibernateUtil.closeSession();
        }
        return result;
    }

    public List<Person> searchPerson(String columnName, Object obj) {
        List<Person> result = new ArrayList<>();

        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();
            Criteria cr = HibernateUtil.getCurrentSession().createCriteria(Person.class);

            cr.add(Restrictions.eq(columnName, obj));

            result = cr.list();
            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
        finally {
            HibernateUtil.closeSession();
        }

        return result;
    }
}