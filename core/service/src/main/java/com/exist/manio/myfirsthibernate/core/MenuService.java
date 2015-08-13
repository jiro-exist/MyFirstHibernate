package com.exist.manio.myfirsthibernate.core.service;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Date;
import java.util.Collections;
import java.util.Comparator;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.dao.PersonDao;

public class MenuService {

    public String getPersons() {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.queryPerson();
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

    public String getPersons(Comparator comparator, String sortOrder) {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.queryPerson();
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            if("asc".equals(sortOrder)) {
                Collections.sort(personList,comparator);
            }
            else {
                Collections.sort(personList,Collections.reverseOrder(comparator));
            }
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

    public String getPersons(String columnName, String sortOrder) {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.queryPerson(columnName, sortOrder);
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
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.searchPerson(columnName, searchString);
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
        PersonDao personDao = new PersonDao();
                System.out.println("a");
        List<Person> personList = personDao.searchPerson(columnName, date);
                System.out.println("b");
        StringBuilder sr = new StringBuilder();
        if(personList.size() > 0) {
            for(Person p : personList) {
                System.out.println("aa");
                sr.append(p.toString());
                System.out.println("aa");
                sr.append("\n");
            }
        }
        else {
            sr.append("Person not found");
        }
        return sr.toString();
    }
}