package com.exist.manio.myfirsthibernate.app;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.exist.manio.myfirsthibernate.infra.persistence.Person;

public class TestMain{


	public static void main(String args[]) {
	    //creating configuration object  
	    Configuration cfg = new Configuration();  
	    cfg.configure();//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory = cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session = factory.openSession();  
	      
	    //creating transaction object  
	    Transaction t = session.beginTransaction();  
	          
	    Person person = new Person("Liezel","G","Cristobal");
	      
	    session.save(person);//persisting the object  
	      
	    t.commit();//transaction is commited 
	    session.close();
	    factory.close();
	}

}