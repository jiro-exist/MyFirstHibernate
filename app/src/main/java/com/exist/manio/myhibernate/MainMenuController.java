package com.exist.manio.myfirsthibernate.app;

import java.util.List;

import com.exist.manio.myfirsthibernate.core.model.Person;
import com.exist.manio.myfirsthibernate.core.model.Contact;
import com.exist.manio.myfirsthibernate.core.model.ContactType;

public interface MainMenuController {

    List<Person> listPerson();
    void addPerson();
    void editPerson();
    void deletePerson();
    /*void addContact();
        Delete a records contact
    void addContactType();
        edit contact type
        delete contact type*/

}