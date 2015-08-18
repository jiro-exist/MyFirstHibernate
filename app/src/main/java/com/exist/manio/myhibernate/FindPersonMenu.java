package com.exist.manio.myfirsthibernate.app;

import java.util.List;
import java.util.Date;
import java.lang.StringBuilder;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;
import com.exist.manio.myfirsthibernate.core.model.Constants;
import com.exist.manio.myfirsthibernate.core.model.Person;


public class FindPersonMenu {

    PersonMenuService personMenuService = new PersonMenuService();

    public String processSearch() {
        printFindPersonMenu();
        switch(ScannerUtil.getInput()) {
            case "1"    :   return findFirstName();

            case "2"    :   return findMiddleName();

            case "3"    :   return findLastName();

            case "4"    :   return findBirthday();

            case "5"    :   System.out.println("Enter the gender:");

            case "6"    :   System.out.println("Employed? (Y/N)");

            case "0"    :   return "";

            default     :   return null;
        }
    }

    private String getSearchString() {
        System.out.println("Enter search value:");
        return ScannerUtil.getInput();
    }

    private String findFirstName() {
        List<Person> personList = personMenuService.searchPersonList("firstName",getSearchString());
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                sr.append(p.toString());
                sr.append("\n");
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }

    private String findMiddleName() {
        List<Person> personList = personMenuService.searchPersonList("middleName",getSearchString());
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                sr.append(p.toString());
                sr.append("\n");
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }

    private String findLastName() {
        List<Person> personList = personMenuService.searchPersonList("lastName",getSearchString());
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                sr.append(p.toString());
                sr.append("\n");
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }

    private String findBirthday() {
        System.out.println("Enter the date (YYYY-MM-DD):");
        String dateInput = ScannerUtil.getInput();
        if(Validator.isDate(dateInput)) {
            Date date = null;
            try {
                date = Constants.DATEFORMAT.parse(dateInput);
            }
            catch (ParseException e) {
                System.out.println("DITO:"+e);
            }
            System.out.println(date);
            List<Person> personList = personMenuService.searchPersonList("birthday",date);
            StringBuilder sr = new StringBuilder();
            if(personList.size() > 0) {
                for(Person p : personList) {
                    sr.append(p.toString());
                    sr.append("\n");
                }
            }
            else {
                sr.append("Person not found");
            }
            return sr.toString();
        }
        else {
            return "Invalid date";
        }
    }


    private void printFindPersonMenu() {
        System.out.println();
        System.out.println("Choose a search parameter:"); 
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