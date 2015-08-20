package com.exist.manio.myfirsthibernate.core.model;

public class Contact {

    private int id;
    private int contactId;
    private String contactCode;
    private String contactValue;
    private Person person;

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
            +   "ID:" + id + "\n"
            +   "Contact Code:" + contactCode + "\n"
            +   "Contact Value:" + contactValue + "\n";
    }

    public void setPerson(Person person) {
        if(person != null) {
            this.person = person;
        }
    }

    public Person getPerson() {
        return this.person;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;

        if (!(obj instanceof Contact)) return false;

        Contact obj2 = (Contact)obj;

        if (this.id != obj2.getId()) return false;

        if (!this.contactCode.equals(obj2.getContactCode())) return false;

        if (!this.contactValue.equals(obj2.getContactValue())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int tmp = 0;
        tmp = ( "" + id + contactCode + contactValue ).hashCode();
        return tmp;
    }

    public Contact() {

    }

    public Contact(Person person, int id, String contactCode, String contactValue) {
        this.person = person;
        this.id = id;
        this.contactCode = contactCode;
        this.contactValue = contactValue;
    }

}