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
import com.exist.manio.myfirsthibernate.core.service.ContactTypeMenuService;

public class AddContactMenu {

	public void add() {

    	PersonMenuService personMenuService = new PersonMenuService();
    	ContactMenuService contactMenuService = new ContactMenuService();
    	ContactTypeMenuService contactTypeMenuService = new ContactTypeMenuService();

		String id = "", contactTypeId = "", contactValue = "";
		Person person = new Person();

		System.out.println("Enter the ID of the person:");
		while(!Validator.isInt(id)) {
			id = ScannerUtil.getInput();
		}
        List<Person> personList = personMenuService.searchPersonList("id",Integer.parseInt(id));
        
		if(personList.size() > 0) {
			person = personList.get(0);
			List<ContactType> contactTypeList = contactTypeMenuService.getContactTypes();
			if(contactTypeList.size() > 0) {
				System.out.println("Please pick a contact type:");
				int a = 1;
				for(ContactType contactType : contactTypeList) {
					System.out.println(a++ + ": " + contactType.toString());
				}
				
				while(!Validator.isInt(contactTypeId, 0, a-1)) {
					contactTypeId = ScannerUtil.getInput();
				}
				
				System.out.println(contactTypeList.get(Integer.parseInt(contactTypeId)-1).toString());
				System.out.println("Enter the contact value:");
				contactValue = ScannerUtil.getInput();

				contactMenuService.add(person, Integer.parseInt(id), contactTypeList.get(Integer.parseInt(contactTypeId)-1).getContactCode(), contactValue);
			}
			else {
				System.out.println("Contact Types not available");
			}

		}
		else {
			System.out.println("Person not found");
		}
	}

}