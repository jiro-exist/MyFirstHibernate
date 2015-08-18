package com.exist.manio.myfirsthibernate.core.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Constants;
import com.exist.manio.myfirsthibernate.core.model.GenderEnum;
import com.exist.manio.myfirsthibernate.core.dao.PersonDao;

public class ContactMenuService {

    public void addPerson(String firstName, String middleName, String lastName, 
                        String birthday, String isEmployed, String gwa, String gender) throws ParseException {

        PersonDao personDao = new PersonDao();

        Boolean employed = null;
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

    public void editPerson(Person person, String firstName, String middleName, String lastName, 
                        String birthday, String isEmployed, String gwa, String gender) throws ParseException {

        PersonDao personDao = new PersonDao();

        Boolean employed = null;
        switch (isEmployed) {

            case "yes"  :
            case "y"    :
                            employed = true;
            case "n"    :
            case "no"   :
                            employed = false;

        }


        if(!"".equals(firstName)) {
            person.setFirstName(firstName);
        }

        if(!"".equals(middleName)) {
            person.setMiddleName(middleName);
        }

        if(!"".equals(lastName)) {
            person.setLastName(lastName);
        }

        if(!"".equals(birthday)) {
            person.setBirthday(Constants.DATEFORMAT.parse(birthday));
        }

        if(employed != null) {
            person.setIsEmployed(employed);
        }

        if(!"".equals(gwa)) {
            person.setGwa(Double.valueOf(gwa));
        }

        if(!"".equals(gender)) {
            person.setGender(gender);
        }

        personDao.update(person);
    }

    public List<Person> getPersons() {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.queryPerson();
        return personList;
    }

    public List<Person> getPersons(Comparator comparator, String sortOrder) {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.queryPerson();

        if("asc".equals(sortOrder)) {
            Collections.sort(personList,comparator);
        }
        else {
            Collections.sort(personList,Collections.reverseOrder(comparator));
        }

        return personList;
    }

    public List<Person> getPersons(String columnName, String sortOrder) {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.queryPerson(columnName, sortOrder);
        return personList;
    }

    public List<Person> searchPersonList(String columnName, Date date) {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.searchPerson(columnName, date);
        return personList;
    }

    public List<Person> searchPersonList(String columnName, String searchString) {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.searchPerson(columnName, searchString);
        return personList;
    }

    public List<Person> searchPersonList(String columnName, int id) {
        PersonDao personDao = new PersonDao();
        List<Person> personList = personDao.searchPerson(columnName, id);
        return personList;
    }

    public boolean delete(int id) {
        PersonDao personDao = new PersonDao();
        return personDao.delete(id);
    }
}