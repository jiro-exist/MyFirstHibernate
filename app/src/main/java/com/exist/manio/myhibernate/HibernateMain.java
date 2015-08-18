package com.exist.manio.myfirsthibernate.app;

import java.util.List;

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
        String chosen = "";

        try {
            do {
                printMainMenu();

                chosen = ScannerUtil.getInput();

                controller.processOption(chosen);

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
        System.out.println("2:Add a person");
        System.out.println("3:Edit a person's record");
        System.out.println("4:Delete a person's record");
        System.out.println("5:Add a person's contact");
        System.out.println("6:Edit a person's contact");
        System.out.println("7:Delete a person's contact");
        System.out.println("0:Exit");
        System.out.println();
    }

}