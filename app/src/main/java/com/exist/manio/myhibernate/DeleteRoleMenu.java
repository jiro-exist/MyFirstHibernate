package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Roles;
import com.exist.manio.myfirsthibernate.core.service.PersonMenuService;
import com.exist.manio.myfirsthibernate.core.service.RolesMenuService;

public class DeleteRoleMenu {

	public void delete() {

    	RolesMenuService roleMenuService = new RolesMenuService();
    	PersonMenuService personMenuService = new PersonMenuService();

		String roleCode = "", roleDesc = "";
		int personId = 0;

		System.out.println("Enter the person's id:");
		personId = ScannerUtil.getInt();

        List<Person> personList = personMenuService.searchPersonList("id",personId);
        
		if(personList.size() > 0) {
			Person person = personList.get(0);

            //print roles
            Set rolesSet = person.getRolesSet();

            if(rolesSet.size() > 0) {
                System.out.println("Current List of Roles:\n");

	            for ( Iterator iter = rolesSet.iterator(); iter.hasNext(); ) { 
	                Roles roles = (Roles) iter.next();
	                System.out.println(roles.toString() + "\n");
	            }
            }


			System.out.println("Enter the role code:");
			roleCode = ScannerUtil.getInput();

			roleMenuService.delete(personId, roleCode);
			
		}
		else {
			System.out.println("Person not found");
		}

	}

}