package com.exist.manio.myfirsthibernate.core.model;

public class Contact {

    private int id;
    private int contactId;
    private String contactCode;
    private String contactValue;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getContactId() {
        return this.contactId;
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

    public String toString() {
        return  "Contact ID:" + contactId + "\n"
            +   "Contact Code:" + contactCode + "\n"
            +   "Contact Value:" + contactValue + "\n";
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Contact obj2 = (Contact)obj;
        if((this.id == obj2.getId()) && (this.contactCode.equals(obj2.getContactCode())) && (this.contactValue.equals(obj2.getContactValue())) ) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int tmp = 0;
        tmp = ( "" + id + contactId ).hashCode();
        return tmp;
    }

    public Contact() {

    }

    public Contact(int id, String contactCode, String contactValue) {
        this.id = id;
        this.contactCode = contactCode;
        this.contactValue = contactValue;
    }

}