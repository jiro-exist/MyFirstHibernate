package com.exist.manio.myfirsthibernate.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.Iterator;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;
import com.exist.manio.myfirsthibernate.core.model.PersonGwaComparator;
import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Contact;

public class DisplayPersonMenu {

    PersonMenuService personMenuService = new PersonMenuService();

    public String processSearch() {
        printDisplayPersonMenu();
        switch(ScannerUtil.getInput()) {
            case "1"    :   return orderByID();

            case "2"    :   return orderByGWA();

            case "3"    :   return orderByBirthday();

            case "4"    :   return orderByName();

            case "0"    :   return "";

            default     :   return null;
        }
    }

    private String orderByID() {
        String sortOrder = getSortOrder();
        
        if("".equals(sortOrder)) {
            return "Incorrect sort order";
        }

        return toString(personMenuService.getPersons("id", sortOrder));
    }

    private String orderByGWA() {
        String sortOrder = getSortOrder();
        
        if("".equals(sortOrder)) {
            return "Incorrect sort order";
        }

        return toString(personMenuService.getPersons("gwa", sortOrder));
    }

    private String orderByBirthday() {
        String sortOrder = getSortOrder();
        
        if("".equals(sortOrder)) {
            return "Incorrect sort order";
        }
        
        return toString(personMenuService.getPersons("birthday", sortOrder));
    }

    private String orderByName() {
        String sortOrder = getSortOrder();

        if("".equals(sortOrder)) {
            return "Incorrect sort order";
        }
        
        return toString(personMenuService.getPersons("lastName", sortOrder));
    }

    private String getSortOrder() {

        printDisplayPersonSortMenu();
        switch(ScannerUtil.getInput()) {
            case "1"    :   return "asc";

            case "2"    :   return "desc";

            default     :   return "";
        }


    }

    private String toString(List<Person> personList) {
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                sr.append("\n");
                sr.append(p.toString());
                sr.append("\n");

                //print address
                if(p.getAddress() != null) {
                    sr.append(p.getAddress().toString());
                    sr.append("\n");
                }

                //print contacts
                Set sets = p.getContactList();

                if(sets.size() > 0) {
                    sr.append("Contacts:\n");
                }

                for ( Iterator iter = sets.iterator(); iter.hasNext(); ) { 
                    Contact contact = (Contact) iter.next();
                    sr.append(contact.toString() + "\n");
                }
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }

    private void printDisplayPersonMenu() {
        System.out.println();
        System.out.println("Choose a sort option:"); 
        System.out.println("1:ID");
        System.out.println("2:GWA");
        System.out.println("3:Birthday");
        System.out.println("4:Last Name");
        System.out.println("0:Return");
        System.out.println();
    }

    private void printDisplayPersonSortMenu() {
        System.out.println();
        System.out.println("Choose a sort order:"); 
        System.out.println("1:Ascending");
        System.out.println("2:Descending");
        System.out.println("0:Return");
        System.out.println();
    }

}