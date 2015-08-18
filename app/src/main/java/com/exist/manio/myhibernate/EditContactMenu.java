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

public class EditContactMenu {

	public void edit() {

    	PersonMenuService personMenuService = new PersonMenuService();
    	ContactMenuService contactMenuService = new ContactMenuService();

    	String contactValue = "";
		int personId = 0, contactId = 0;
		Person person = new Person();

		System.out.println("Enter the ID of the person:");
		personId = ScannerUtil.getInt();

        List<Person> personList = personMenuService.searchPersonList("id",personId);
        
		if(personList.size() > 0) {
			person = personList.get(0);
			List<Contact> contactList = contactMenuService.searchContactList("id",personId);

			for(Contact contact : contactList) {
				System.out.println(contact.toString());
			}

			System.out.println("Enter the contact ID:");
			contactId = ScannerUtil.getInt();
			
			List<Contact> editContactList = contactMenuService.searchContactList("contactId",contactId);

			if(editContactList.size() > 0) {
				Contact contact = editContactList.get(0);

				System.out.println("Enter the new contact value:");
				contactValue = ScannerUtil.getInput();

				contactMenuService.edit(person, contact, contactValue);
			}
			else {
				System.out.println("Contact id not found");
			}

		}
		else {
			System.out.println("Person not found");
		}
	}

}