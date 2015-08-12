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

        MainMenuController controller = new MainMenuController();

        System.out.println("Welcome~");
        String chosen = "", result = "";

        try {
            do {
                printMainMenu();

                chosen = ScannerUtil.getInput();

                result = controller.processOption(chosen);

                System.out.println(result);

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

}