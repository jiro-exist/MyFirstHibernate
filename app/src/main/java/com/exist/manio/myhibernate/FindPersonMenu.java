package com.exist.manio.myfirsthibernate.app;

import com.exist.manio.myfirsthibernate.core.service.MenuService;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

public class FindPersonMenu {

    MenuService menuService = new MenuService();

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
        return menuService.searchPersonList("firstName",getSearchString());
    }

    private String findMiddleName() {
        return menuService.searchPersonList("middleName",getSearchString());
    }

    private String findLastName() {
        return menuService.searchPersonList("lastName",getSearchString());
    }

    private String findBirthday() {
        System.out.println("Enter the date (YYYY-MM-DD):");
        String dateInput = ScannerUtil.getInput();
        if(Validator.validateDate(dateInput)) {
            Date date = null;
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
                date = formatter.parse(dateInput);
            }
            catch (ParseException e) {
                System.out.println(e);
            }
            return menuService.searchPersonList("lastName",date);
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