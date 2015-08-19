package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Contact;
import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;
import com.exist.manio.myfirsthibernate.core.service.ContactMenuService;

public class DeleteContactMenu {

	public boolean delete() {

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

            Set contactList = person.getContactList();

			if(contactList.size()>0) {
	            System.out.println("Contacts:\n");

	            for ( Iterator iter = contactList.iterator(); iter.hasNext(); ) { 
	                Contact contact = (Contact) iter.next();
	                System.out.println(contact.toString() + "\n");
	            }

				System.out.println("Enter the contact ID:");
				contactId = ScannerUtil.getInt();

	            for ( Iterator iter = contactList.iterator(); iter.hasNext(); ) { 
	                Contact contact = (Contact) iter.next();
					if(contact.getContactId() == contactId) {
						return contactMenuService.delete(person, contact);
					}
	            }
				
				return false;
			}
			else {
				return false;
			}

		}
		else {
			return false;
		}

	}

}