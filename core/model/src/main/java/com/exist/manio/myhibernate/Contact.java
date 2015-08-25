package com.exist.manio.myfirsthibernate.core.model;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "contact")
public class Contact {

    private Long id;
    private Long contactId;
    private String contactCode;
    private String contactValue;
    private Person person;

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="id")
    public Long getId() {
        return this.id;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    @Id
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name = "contact_id", unique = true, nullable = false)
    public Long getContactId() {
        return this.contactId;
    }

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    @Column(name="contact_code")
    public String getContactCode() {
        return this.contactCode;
    }

    public void setContactValue(String contactValue) {
        this.contactValue = contactValue;
    }

    @Column(name="contact_value")
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", nullable = false, insertable=false, updatable=false)
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

    public Contact(Person person, Long id, String contactCode, String contactValue) {
        this.person = person;
        this.id = id;
        this.contactCode = contactCode;
        this.contactValue = contactValue;
    }

}