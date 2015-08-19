package com.exist.manio.myfirsthibernate.core.model;

import java.util.Date;
import java.util.Set;
import java.util.ArrayList;

public class Person {

    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthday;
    private Boolean isEmployed;
    private Double gwa;
    private String gender;
    private Set<Contact> contactList;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setIsEmployed(Boolean isEmployed) {
        this.isEmployed = isEmployed;
    }

    public Boolean getIsEmployed() {
        return this.isEmployed;
    }

    public void setGwa(Double gwa) {
        this.gwa = gwa;
    }

    public Double getGwa() {
        return this.gwa;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return this.gender;
    }

    public void setContactList(Set<Contact> contactList) {
        if(contactList != null) {
            this.contactList = contactList;
        }
    }

    public Set<Contact> getContactList () {
        return this.contactList;
    }

    public Person() {

    }

    public String toString() {
        String personData = "ID:" + id + "\n"
                 + "Name:" + firstName + " " + middleName + " " + lastName + "\n"
                 + "Birthday:" + birthday + "\n"
                 + "Gender:" + gender + "\n"
                 + "Employed:" + isEmployed + "\n"
                 + "GWA:" + gwa + "\n";
                 
        return personData;
    }

    public Person(String firstName, String middleName, String lastName, 
                        Date birthday, Boolean isEmployed, Double gwa, String gender) {

        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.isEmployed = isEmployed;
        this.gwa = gwa;
        this.gender = gender;

    }

}