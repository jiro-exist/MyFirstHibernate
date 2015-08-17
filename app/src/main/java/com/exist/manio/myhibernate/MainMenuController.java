package com.exist.manio.myfirsthibernate.app;

import java.util.List;

import com.exist.manio.myfirsthibernate.core.service.MenuService;
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
			System.out.println("Person was not deleted");
		}
	}

}