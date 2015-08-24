package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;

public class DeletePersonMenu {

	public boolean delete() {

    	PersonMenuService personMenuService = new PersonMenuService();
    	String id = "";

		System.out.println("Enter the ID of the person:");
		while(!Validator.isInt(id)) {
			id = ScannerUtil.getInput();
		}

        List<Person> personList = personMenuService.searchPersonList("id",Integer.parseInt(id));
        
		if(personList.size() > 0) {
			Person person = personList.get(0);
			return personMenuService.delete(person);
		}

		return false;
	}

}