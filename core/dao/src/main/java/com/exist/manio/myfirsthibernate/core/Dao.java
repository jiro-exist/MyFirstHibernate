package com.exist.manio.myfirsthibernate.core.dao;

import java.util.List;
import java.util.ArrayList;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.exist.manio.myfirsthibernate.core.dao.HibernateUtil;
import com.exist.manio.myfirsthibernate.core.model.Person;

public class Dao {
	
	public Dao() {
	}

	public List<Person> queryPerson() {
                Session session = HibernateUtil.getSessionFactory().openSession();
                Criteria cr = session.createCriteria(Person.class);
                List<Person> listPerson = cr.list();
                session.close();

                return listPerson;
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

        

}