package com.exist.manio.myfirsthibernate.core.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Roles;
import com.exist.manio.myfirsthibernate.core.model.Constants;
import com.exist.manio.myfirsthibernate.core.model.GenderEnum;
import com.exist.manio.myfirsthibernate.core.dao.PersonDao;
import com.exist.manio.myfirsthibernate.core.dao.RolesDao;

public class RolesMenuService {

    public void add(int personId, String roleCode) {

        RolesDao rolesDao = new RolesDao();
        rolesDao.save(new Long(personId), roleCode);

    }

    public void edit(Roles roles, String roleDesc) {

        RolesDao rolesDao = new RolesDao();

        if(!"".equals(roleDesc)) {
            roles.setRoleDesc(roleDesc);
        }

        rolesDao.save(roles);
    }

    public void delete(int personId, String roleCode) {
        RolesDao rolesDao = new RolesDao();
        rolesDao.delete(new Long(personId), roleCode);
    }

    public List<Roles> getRolesList() {
        RolesDao rolesDao = new RolesDao();
        List<Roles> rolesList = rolesDao.getRoles();

        return rolesList;
    }

    public List<Roles> searchRolesList(String columnName, String searchStr) {
        RolesDao rolesDao = new RolesDao();
        List<Roles> rolesList = rolesDao.searchRoles(columnName, searchStr);

        return rolesList;
    }

}