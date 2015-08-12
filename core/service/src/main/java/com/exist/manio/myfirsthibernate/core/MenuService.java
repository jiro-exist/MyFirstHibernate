package com.exist.manio.myfirsthibernate.core.service;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Date;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.dao.Dao;

public class MenuService {

    public String getPersonList() {
        Dao dao = new Dao();
        List<Person> personList = dao.queryPerson();
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                sr.append(p.toString());
                sr.append("\n");
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }

    public String searchPersonList(String columnName, String searchString) {
        Dao dao = new Dao();
        List<Person> personList = dao.searchPersonByString(columnName, searchString);
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                sr.append(p.toString());
                sr.append("\n");
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }

    public String searchPersonList(String columnName, Date date) {
        Dao dao = new Dao();
        List<Person> personList = dao.searchPersonByString(columnName, "");
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                sr.append(p.toString());
                sr.append("\n");
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }
}