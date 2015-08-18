package com.exist.manio.myfirsthibernate.app;

import java.util.List;

import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;
import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Contact;
import com.exist.manio.myfirsthibernate.core.model.ContactType;

public class MainMenuController {

	public void processOption(String chosen) {
		switch(chosen) {
			case "1"	:	listPerson();
							break;

			case "2"	:	addPerson();
							break;

			case "3"	:	editPerson();
							break;

			case "4"	:	deletePerson();
							break;

			case "5"	:	addContact();
							break;

			case "6"	:	editContact();
							break;

			case "7"	:	deleteContact();
							break;

			case "0"	:	System.out.println("System Exiting.");
							break;

			default		:	System.out.println("Incorrect Option");
		}
	}

	private void listPerson() {
		DisplayPersonMenu displayPerson = new DisplayPersonMenu();
		System.out.println(displayPerson.processSearch());
	}

	private void addPerson() {
		AddPersonMenu addPersonMenu = new AddPersonMenu();
		addPersonMenu.add();
		System.out.println("Successfully added a person.");
	}

	private void editPerson() {
		EditPersonMenu editPersonMenu = new EditPersonMenu();
		editPersonMenu.edit();
	}

	private void deletePerson() {
		DeletePersonMenu deletePersonMenu = new DeletePersonMenu();
		if(deletePersonMenu.delete()) {
			System.out.println("Person successfully deleted");
		}
		else {
			System.out.println("Person was not found");
		}
	}

	private void addContact() {
		AddContactMenu addContactMenu = new AddContactMenu();
		addContactMenu.add();
	}

	private void editContact() {
		EditContactMenu editContactMenu = new EditContactMenu();
		editContactMenu.edit();
	}

	private void deleteContact() {
		DeleteContactMenu deleteContactMenu = new DeleteContactMenu();
		if(deleteContactMenu.delete()) {
			System.out.println("Contact Successfully Deleted.");
		}
		else {
			System.out.println("Contact was not found");
		}
	}

}