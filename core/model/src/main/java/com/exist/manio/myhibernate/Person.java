package com.exist.manio.myfirsthibernate.core.model;

import java.util.Date;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "person")
public class Person extends BaseModel {

    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthday;
    private Boolean isEmployed;
    private Double gwa;
    private String gender;
    private Address address;
    private Set<Contact> contactSet = new HashSet<Contact>(0);
    private Set<Roles> rolesSet = new HashSet<Roles>(0);

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return this.firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "middle_name")
    public String getMiddleName() {
        return this.middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return this.lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Column(name = "birthday")
    public Date getBirthday() {
        return this.birthday;
    }

    public void setIsEmployed(Boolean isEmployed) {
        this.isEmployed = isEmployed;
    }

    @Column(name = "is_employed")
    public Boolean getIsEmployed() {
        return this.isEmployed;
    }

    public void setGwa(Double gwa) {
        this.gwa = gwa;
    }

    @Column(name = "gwa")
    public Double getGwa() {
        return this.gwa;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Column(name = "gender")
    public String getGender() {
        return this.gender;
    }

    public void setContactSet(Set<Contact> contactSet) {
        if(contactSet != null) {
            this.contactSet = contactSet;
        }
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
    public Set<Contact> getContactSet () {
        return this.contactSet;
    }

    public void setAddress(Address address) {
        if(address != null) {
            this.address = address;
        }
    }

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
    public Address getAddress() {
        return this.address;
    }

    public void setRolesSet (Set<Roles> rolesSet) {
        if(rolesSet != null) {
            this.rolesSet = rolesSet;
        }
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "person_roles", joinColumns = {
        @JoinColumn(name = "person_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "role",
            nullable = false, updatable = false) })
    public Set<Roles> getRolesSet() {
        return this.rolesSet;
    }

    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) return true;

        if (!(obj instanceof Person)) return false;

        Person obj2 = (Person)obj;

        if (this.getId() != obj2.getId()) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return this.getId().intValue();
    }

    public Person() {

    }

    public String toString() {
        String personData = "ID:" + this.getId() + "\n"
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