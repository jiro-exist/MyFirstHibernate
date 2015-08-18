package com.exist.manio.myfirsthibernate.core.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.text.ParseException;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Contact;
import com.exist.manio.myfirsthibernate.core.model.Constants;
import com.exist.manio.myfirsthibernate.core.model.GenderEnum;
import com.exist.manio.myfirsthibernate.core.dao.PersonDao;
import com.exist.manio.myfirsthibernate.core.dao.ContactDao;

public class ContactMenuService {

    public void add(Person person, int id, String contactType, String contactValue) {

        ContactDao contactDao = new ContactDao();

        Contact contact = new Contact(id, contactType, contactValue);

        contactDao.add(contact);
        person.getContactList().add(contact);
    }

    public void edit(Person person, Contact contact, String contactValue) {

        ContactDao contactDao = new ContactDao();

        if(!"".equals(contactValue)) {
            contact.setContactValue(contactValue);
        }

        contactDao.update(contact);
        person.getContactList().remove(contact);
        person.getContactList().add(contact);
    }

    public boolean delete(Person person, Contact contact) {
        ContactDao contactDao = new ContactDao();
        if(contactDao.delete(contact)) {
            person.getContactList().remove(contact);
            return true;
        }
        return false;
    }

    // public List<Contact> getContacts() {
    //     ContactDao contactDao = new ContactDao();
    //     List<Contact> contactList = contactDao.queryContact();
    //     return contactList;
    // }

    // public List<Contact> getContacts(Comparator comparator, String sortOrder) {
    //     ContactDao contactDao = new ContactDao();
    //     List<Contact> contactList = contactDao.queryContact();

    //     if("asc".equals(sortOrder)) {
    //         Collections.sort(contactList,comparator);
    //     }
    //     else {
    //         Collections.sort(contactList,Collections.reverseOrder(comparator));
    //     }

    //     return contactList;
    // }

    // public List<Contact> getContacts(String columnName, String sortOrder) {
    //     ContactDao personDao = new ContactDao();
    //     List<Contact> personList = personDao.queryContact(columnName, sortOrder);
    //     return personList;
    // }

    // public List<Contact> searchContactList(String columnName, Date date) {
    //     ContactDao personDao = new ContactDao();
    //     List<Contact> personList = personDao.searchContact(columnName, date);
    //     return personList;
    // }

    // public List<Contact> searchContactList(String columnName, String searchString) {
    //     ContactDao personDao = new ContactDao();
    //     List<Contact> personList = personDao.searchContact(columnName, searchString);
    //     return personList;
    // }

    public List<Contact> searchContactList(String columnName, int id) {
        ContactDao personDao = new ContactDao();
        List<Contact> personList = personDao.searchContact(columnName, id);
        return personList;
    }

}