package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.service.MenuService;

public class AddPersonMenu {

	public void add() {

		String firstName = "", middleName = "", lastName = "", birthday = "", getInput = "", gwa = "", isEmployed = "", gender = "";

		System.out.println("Enter the details below to add the person:");

		System.out.println("First Name:");
		while(!Validator.isName(firstName)) {
			firstName = ScannerUtil.getInput();
		}

		System.out.println("Middle Name:");
		while(!Validator.isName(middleName)) {
			middleName = ScannerUtil.getInput();
		}

		System.out.println("Last Name:");
		while(!Validator.isName(lastName)) {
			lastName = ScannerUtil.getInput();
		}

		System.out.println("Birthday (YYYY-MM-DD):");
		while(!Validator.isDate(birthday)) {
			birthday = ScannerUtil.getInput();
		}

		System.out.println("Gender (M/F):");
		while(!Validator.isGender(gender)) {
			gender = ScannerUtil.getInput();
		}

		System.out.println("General Weigthed Average:");
		while(!Validator.isNumeric(gwa)) {
			gwa = ScannerUtil.getInput();
		}

		System.out.println("Currently Employed? (Y/N):");
		while(!Validator.isBoolean(isEmployed)) {
			isEmployed = ScannerUtil.getInput();
		}

    	MenuService menuService = new MenuService();

        try {
    		menuService.addPerson(firstName, middleName, lastName, birthday, isEmployed, gwa, gender);
        }
        catch (ParseException e) {
			System.out.println("parse false");
        }

	}

}