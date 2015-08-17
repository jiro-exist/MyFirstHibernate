package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.service.MenuService;

public class DeletePersonMenu {

	public boolean delete() {

    	MenuService menuService = new MenuService();
    	String id = "";

		System.out.println("Enter the ID of the person:");
		while(!Validator.isInt(id)) {
			id = ScannerUtil.getInput();
		}

		return menuService.deletePerson(Integer.parseInt(id));

	}

}