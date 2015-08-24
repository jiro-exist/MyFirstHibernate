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
import com.exist.manio.myfirsthibernate.core.model.Roles;

public class RolesDao {

    public RolesDao() {
    }

    public void save(Roles roles) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            HibernateUtil.getCurrentSession().saveOrUpdate(roles);

            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    public void save(int personId, String roleCode) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            Person person = (Person) HibernateUtil.getCurrentSession().get(Person.class, personId);
            Roles roles = (Roles) HibernateUtil.getCurrentSession().get(Roles.class, roleCode);

            person.getRolesSet().add(roles);

            HibernateUtil.getCurrentSession().saveOrUpdate(person);

            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    public void delete(int personId, String roleCode) {
        Transaction tx = null;

        try {
            tx = HibernateUtil.beginTransaction();

            Person person = (Person) HibernateUtil.getCurrentSession().get(Person.class, personId);
            Roles roles = (Roles) HibernateUtil.getCurrentSession().get(Roles.class, roleCode);
            person.getRolesSet().remove(roles);

            HibernateUtil.getCurrentSession().saveOrUpdate(roles);

            tx.commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

    public List<Roles> getRoles() {
        List<Roles> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Roles.class);

        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

    public List<Roles> queryRoles(String columnName, String sortOrder) {
        List<Roles> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Roles.class);
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

    public List<Roles> searchRoles(String columnName, String searchString) {
        List<Roles> result = new ArrayList<>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        Criteria cr = session.createCriteria(Roles.class);

        cr.add(Restrictions.ilike(columnName,searchString));
        result = cr.list();
        t.commit();
        session.close();

        return result;
    }

}