package com.exist.manio.myfirsthibernate.core.service;

import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Constants;
import com.exist.manio.myfirsthibernate.core.model.GenderEnum;
import com.exist.manio.myfirsthibernate.core.dao.PersonDao;

public class MenuService {

    public void addPerson(String firstName, String middleName, String lastName, 
                        String birthday, String isEmployed, String gwa, String gender) throws ParseException {

        PersonDao personDao = new PersonDao();

        Boolean employed = false;
        switch (isEmployed) {

            case "yes"  :
            case "y"    :
                            employed = true;
            case "n"    :
            case "no"   :
                            employed = false;

        }

        Person person = new Person(firstName, middleName, lastName,
                                    Constants.DATEFORMAT.parse(birthday),
                                    employed, 
                                    Double.valueOf(gwa), 
                                    GenderEnum.getByCode(gender).getDescription());

        personDao.add(person);
    }

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