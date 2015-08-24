package com.exist.manio.myfirsthibernate.core.model;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "contact_type")
public class ContactType {

    private String contactCode;
    private String contactDesc;

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    @Id
    @Column(name = "contact_code")
    public String getContactCode() {
        return this.contactCode;
    }

    public void setContactDesc(String contactDesc) {
        this.contactDesc = contactDesc;
    }

    @Column(name = "contact_desc")
    public String getContactDesc() {
        return this.contactDesc;
    }

    public String toString() {
        return contactDesc + " (" + contactCode + ")";
    }

    public ContactType() {

    }

    public ContactType(String contactCode, String contactDesc) {
        this.contactCode = contactCode;
        this.contactDesc = contactDesc;
    }

}