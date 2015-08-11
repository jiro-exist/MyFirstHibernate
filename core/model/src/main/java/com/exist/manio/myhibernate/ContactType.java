package com.exist.manio.myfirsthibernate.core.model;

public class ContactType {

    String contactCode;
    String contactDesc;

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    public String getContactCode() {
        return this.contactCode;
    }

    public void setContactDesc(String contactDesc) {
        this.contactDesc = contactDesc;
    }

    public String getContactDesc() {
        return this.contactDesc;
    }

    public ContactType() {

    }

    public ContactType(String contactCode, String contactDesc) {
        this.contactCode = contactCode;
        this.contactDesc = contactDesc;
    }

}