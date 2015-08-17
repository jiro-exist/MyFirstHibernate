package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.service.MenuService;

public class EditPersonMenu {

	public void edit() {

    	MenuService menuService = new MenuService();
		String firstName = "", middleName = "", lastName = "", birthday = "", getInput = "", gwa = "", isEmployed = "", gender = "", id = "";
		Person person = new Person();

		System.out.println("Enter the ID of the person:");
		while(!Validator.isInt(id)) {
			id = ScannerUtil.getInput();
		}
        List<Person> personList = menuService.searchPersonList("id",Integer.parseInt(id));
        
		if(personList.size() > 0) {
			person = personList.get(0);
            System.out.println(person.toString());

			System.out.println("First Name:");
			do {
				firstName = ScannerUtil.getInput();
			} while(!Validator.isName(firstName) && !"".equals(firstName));

			System.out.println("Middle Name:");
			do {
				middleName = ScannerUtil.getInput();
			} while(!Validator.isName(middleName) && !"".equals(middleName));

			System.out.println("Last Name:");
			do {
				lastName = ScannerUtil.getInput();
			} while(!Validator.isName(lastName) && !"".equals(lastName));

			System.out.println("Birthday (YYYY-MM-DD):");
			do {
				birthday = ScannerUtil.getInput();
			} while(!Validator.isDate(birthday) && !"".equals(birthday));

			System.out.println("Gender (M/F):");
			do {
				gender = ScannerUtil.getInput();
			} while(!Validator.isGender(gender) && !"".equals(gender));

			System.out.println("General Weigthed Average:");
			do {
				gwa = ScannerUtil.getInput();
			} while(!Validator.isNumeric(gwa) && !"".equals(gwa));

			System.out.println("Currently Employed? (Y/N):");
			do {
				isEmployed = ScannerUtil.getInput();
			} while(!Validator.isBoolean(isEmployed) && !"".equals(isEmployed));

	        try {
	    		menuService.editPerson(person, firstName, middleName, lastName, birthday, isEmployed, gwa, gender);
	        }
	        catch (ParseException e) {
				System.out.println("parse false");
	        }

		}
		else {
			System.out.println("Person not found");
		}
	}

}