package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Contact;
import com.exist.manio.myfirsthibernate.core.model.ContactType;
import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;
import com.exist.manio.myfirsthibernate.core.service.ContactMenuService;

public class AddContactMenu {

	public void edit() {

    	PersonMenuService personMenuService = new PersonMenuService();
		String id = "";
		Person person = new Person();
		ContactType contactType = new ContactType();

		System.out.println("Enter the ID of the person:");
		while(!Validator.isInt(id)) {
			id = ScannerUtil.getInput();
		}
        List<Person> personList = personMenuService.searchPersonList("id",Integer.parseInt(id));
        
		if(personList.size() > 0) {
			person = personList.get(0);




	   //      try {
	   //  		menuService.editPerson(person, firstName, middleName, lastName, birthday, isEmployed, gwa, gender);
	   //      }
	   //      catch (ParseException e) {
				// System.out.println("parse false");
	   //      }

		}
		else {
			System.out.println("Person not found");
		}
	}

}