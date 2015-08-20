package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Roles;
import com.exist.manio.myfirsthibernate.core.model.Contact;
import com.exist.manio.myfirsthibernate.core.model.ContactType;
import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;
import com.exist.manio.myfirsthibernate.core.service.ContactMenuService;
import com.exist.manio.myfirsthibernate.core.service.ContactTypeMenuService;

public class AddRoleMenu {

	public void add() {

    	PersonMenuService personMenuService = new PersonMenuService();
    	ContactMenuService contactMenuService = new ContactMenuService();
    	ContactTypeMenuService contactTypeMenuService = new ContactTypeMenuService();

		String roleCode = "", roleDesc = "";
		Person person = new Person();
		Roles roles = new Roles();

		System.out.println("Enter the role code:");
		roleCode = ScannerUtil.getInput();

		System.out.println("Enter the role description:");
		roleDesc = ScannerUtil.getInput();
	}

}