package com.exist.manio.myfirsthibernate.app;

import java.util.List;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.exist.manio.myfirsthibernate.infra.persistence.Person;
import com.exist.manio.myfirsthibernate.core.dao.HibernateUtil;
import com.exist.manio.myfirsthibernate.core.model.PersonModel;

public class HibernateMain {


	public static void main(String args[]) {

		System.out.println("Welcome~");

		String chosen = "";

	    try {
			do {
				printMainMenu();

				chosen = ScannerUtil.getInput();

					Session session = HibernateUtil.getSessionFactory().openSession();

				    //creating transaction object  
				    Transaction t = session.beginTransaction();

				    Person person = new Person("test","test","test");

				    session.save(person);//persisting the object

				    t.commit();//transaction is commited

				    Criteria cr = session.createCriteria(Person.class);
				    cr.add(Restrictions.ilike("firstName","Liezel"));

				    List<Person> personList = cr.list();
				    System.out.println("count:" + personList.size());
				    for(Person p : personList) {
				    	System.out.println("Name:" + p.getFirstName() + " " + p.getMiddleName() + " " + p.getLastName());
				    	p.setMiddleName("Cristobal");
				    	p.setLastName("Manio");
				    	t = session.beginTransaction();
				    	session.update(p);
				    	t.commit();
				    }

			    	session.close();
			}while(!"0".equals(chosen));
	    }
	    catch (Exception e) {
	    	System.out.println("main error:" + e);
	    }
	    finally {
	    	HibernateUtil.closeSessionFactory();
	    }
	}

	public static void printMainMenu() {
		System.out.println();
		System.out.println("Choose from the list below:");
		System.out.println("1:List all recored");
		System.out.println("2:Enroll a new person");
		System.out.println("3:Edit a record");
		System.out.println("4:Delete a record");
		System.out.println("4:Add a record's contact");
		System.out.println("5:Delete a record's contact");
		System.out.println("6:Add a contact type");
		System.out.println("0:Exit");
		System.out.println();
	}

	public static void printEditMenu() {
		System.out.println();
		System.out.println("1:All");
		System.out.println("2:First Name");
		System.out.println("3:Middle Name");
		System.out.println("4:Last Name");
		System.out.println("5:Birthday");
		System.out.println("6:Gender");
		System.out.println("7:Employment Status");
		System.out.println("8:General Weighted Average");
		System.out.println("0:None");
		System.out.println();
	}

}