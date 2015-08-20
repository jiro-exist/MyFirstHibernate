package com.exist.manio.myfirsthibernate.app;

import java.util.Date;
import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

import com.exist.manio.myfirsthibernate.core.model.Roles;
import com.exist.manio.myfirsthibernate.core.service.RolesMenuService;

public class EditRoleMenu {

	public void edit() {

    	RolesMenuService roleMenuService = new RolesMenuService();

		String roleCode = "", roleDesc = "";
		Roles roles = new Roles();

		System.out.println("Enter the role code:");
		roleCode = ScannerUtil.getInput();

		List<Roles> rolesList = roleMenuService.searchRolesList("role",roleCode);

		if(rolesList.size() > 0) {
			roles = rolesList.get(0);
			System.out.println("Enter the new role description:");
			roleDesc = ScannerUtil.getInput();
			roleMenuService.edit(roles, roleDesc);

			System.out.println("Role description updated");
		}
		else {
			System.out.println("Role not found");
		}
	}

}