package com.exist.manio.myfirsthibernate.core.model;

public class Contact {

    int id;
    String contactCode;
    String contactValue;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    public String getContactCode() {
        return this.contactCode;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    public String getContactValue() {
        return this.contactValue;
    }

    public Contact() {

    }

    public Contact(String contactCode, String contactValue) {
        this.contactCode = contactCode;
        this.contactValue = contactValue;
    }

}