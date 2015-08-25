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

    public boolean add(Person person, int id, String contactType, String contactValue) {

        ContactDao contactDao = new ContactDao();

        Contact contact = new Contact(person, new Long(id), contactType, contactValue);

        if(person.getContactSet().add(contact)) {
            contactDao.save(contact);
            return true;
        }
        else {
            return false;
        }
    }

    public void edit(Person person, Contact contact, String contactValue) {

        ContactDao contactDao = new ContactDao();

        if(!"".equals(contactValue)) {
            contact.setContactValue(contactValue);
        }

        contactDao.save(contact);
    }

    public boolean delete(Person person, Contact contact) {
        ContactDao contactDao = new ContactDao();
        if(contactDao.delete(contact)) {
            person.getContactSet().remove(contact);
            return true;
        }
        return false;
    }

    public List<Contact> searchContactList(String columnName, int id) {
        ContactDao contactDao = new ContactDao();
        List<Contact> contactList = contactDao.searchContact(columnName, new Long(id));
        return contactList;
    }

    public List<Contact> searchContactList(String columnName, String searchStr) {
        ContactDao contactDao = new ContactDao();
        List<Contact> contactList = contactDao.searchContact(columnName, searchStr);
        return contactList;
    }

}