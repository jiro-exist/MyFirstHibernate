package com.exist.manio.myfirsthibernate.app;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.hibernate.HibernateException; 
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.exist.manio.myfirsthibernate.core.dao.HibernateUtil;
import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.GenderEnum;

public class HibernateMain {


    public static void main(String args[]) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");

        System.out.println("Welcome~");
        String chosen = "";

        try {
            do {
                printMainMenu();

                chosen = ScannerUtil.getInput();

                    Session session = HibernateUtil.getSessionFactory().openSession();

                    //creating transaction object  
                    Transaction t = session.beginTransaction();

                    Date date = formatter.parse("2015-06-06");

                    Person person = new Person("test","test","test",date,true,69.9,GenderEnum.MALE.getDescription());

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
        System.out.println("1:Display everyone");
        System.out.println("2:Search for a person");
        System.out.println("3:Edit a person's record");
        System.out.println("4:Delete a person's record");
        System.out.println("5:Add a person's contact");
        System.out.println("6:Delete a person's contact");
        System.out.println("7:Add a contact type");
        System.out.println("8:Edit a contact type");
        System.out.println("9:Delete a contact type");
        System.out.println("0:Exit");
        System.out.println();
    }

    public static void printEditPersonMenu() {
        System.out.println();
        System.out.println("1:All");
        System.out.println("2:First Name");
        System.out.println("3:Middle Name");
        System.out.println("4:Last Name");
        System.out.println("5:Birthday");
        System.out.println("6:Gender");
        System.out.println("7:Employment Status");
        System.out.println("8:General Weighted Average");
        System.out.println("0:Return");
        System.out.println();
    }

    public static void printFindPersonMenu() {
        System.out.println();
        System.out.println("1:First Name");
        System.out.println("2:Middle Name");
        System.out.println("3:Last Name");
        System.out.println("4:Birthday");
        System.out.println("5:Gender");
        System.out.println("6:Employment Status");
        System.out.println("7:General Weighted Average");
        System.out.println("0:Return");
        System.out.println();
    }

}