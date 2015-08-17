package com.exist.manio.myfirsthibernate.app;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.service.MenuService;
import com.exist.manio.myfirsthibernate.core.model.PersonGwaComparator;
import com.exist.manio.myfirsthibernate.core.model.Person;

public class DisplayPersonMenu {

    MenuService menuService = new MenuService();

    public String processSearch() {
        printDisplayPersonMenu();
        switch(ScannerUtil.getInput()) {
            case "1"    :   return orderByGWA();

            case "2"    :   return orderByBirthday();

            case "3"    :   return orderByName();

            case "0"    :   return "";

            default     :   return null;
        }
    }

    private String orderByGWA() {
        String sortOrder = getSortOrder();
        
        if("".equals(sortOrder)) {
            return "Incorrect sort order";
        }

        return toString(menuService.getPersons("lastName", sortOrder));
    }

    private String orderByBirthday() {
        String sortOrder = getSortOrder();
        
        if("".equals(sortOrder)) {
            return "Incorrect sort order";
        }
        
        return toString(menuService.getPersons("lastName", sortOrder));
    }

    private String orderByName() {
        String sortOrder = getSortOrder();

        if("".equals(sortOrder)) {
            return "Incorrect sort order";
        }
        
        return toString(menuService.getPersons("lastName", sortOrder));
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
        System.out.println("1:GWA");
        System.out.println("2:Birthday");
        System.out.println("3:Last Name");
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