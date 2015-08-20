package com.exist.manio.myfirsthibernate.core.model;

import java.util.Set;
import java.util.HashSet;

public class Roles {

    private String role;
    private String roleDesc;
    private Set<Person> personList;

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public String getRoleDesc() {
        return this.roleDesc;
    }

    public void setPersonList(Set<Person> personList) {
        if(personList != null) {
            this.personList = personList;
        }
    }

    public Set<Person> getPersonList() {
        return this.personList;
    }

    public String toString() {
        return "Role:" + roleDesc + " (" + role + ")";
    }

    public Roles() {

    }

    public Roles(String role, String roleDesc) {
        this.role = role;
        this.roleDesc = roleDesc;
    }

}