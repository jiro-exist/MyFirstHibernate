package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.service.MenuService;
import com.exist.manio.myfirsthibernate.core.model.PersonGwaComparator;

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
        printDisplayPersonSortMenu();
        switch(ScannerUtil.getInput()) {
            case "1"    :   return menuService.getPersons(new PersonGwaComparator(),"asc");

            case "2"    :   return menuService.getPersons(new PersonGwaComparator(),"desc");

            default     :   return "Incorrect sort order";
        }
    }

    private String orderByBirthday() {
        printDisplayPersonSortMenu();
        switch(ScannerUtil.getInput()) {
            case "1"    :   return menuService.getPersons("birthday","asc");

            case "2"    :   return menuService.getPersons("birthday","desc");

            default     :   return "Incorrect sort order";
        }
    }

    private String orderByName() {
        printDisplayPersonSortMenu();
        switch(ScannerUtil.getInput()) {
            case "1"    :   return menuService.getPersons("lastName","asc");

            case "2"    :   return menuService.getPersons("lastName","desc");

            default     :   return "Incorrect sort order";
        }
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