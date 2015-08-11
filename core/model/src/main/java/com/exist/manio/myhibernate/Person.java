package com.exist.manio.myfirsthibernate.core.model;

import java.util.Date;

public class Person {

    int id;
    String firstName;
    String middleName;
    String lastName;
    Date birthday;
    Boolean isEmployed;
    Double gwa;
    String gender;


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

    public Person() {

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