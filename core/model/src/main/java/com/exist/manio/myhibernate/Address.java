package com.exist.manio.myfirsthibernate.core.model;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "address")
public class Address {

    private Long id;
    private String houseNumber;
    private String street;
    private String barangay;
    private String subdivision;
    private String city;
    private String zipCode;
    private Person person;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "generator")
    @GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "person"))
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return this.id;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Column(name = "house_number")
    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "street")
    public String getStreet() {
        return this.street;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    @Column(name = "barangay")
    public String getBarangay() {
        return this.barangay;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    @Column(name = "subdivision")
    public String getSubdivision() {
        return this.subdivision;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "city")
    public String getCity() {
        return this.city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "zip_code")
    public String getZipCode() {
        return this.zipCode;
    }

    public void setPerson(Person person) {
        if(person != null) {
            this.person = person;
        }
    }

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    public Person getPerson() {
        return this.person;
    }

    public String toString() {
        return  "HouseNumber:" + houseNumber + "\n"
              + "Street:" + street + "\n"
              + "Subdivision:" + subdivision + "\n"
              + "Barangay:" + barangay + "\n"
              + "City:" + city + "\n"
              + "Zip Code:" + zipCode + "\n";
    }

    public Address() {

    }
    
    public Address(String houseNumber,String street, String barangay, String subdivision, String city, String zipCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.barangay = barangay;
        this.subdivision = subdivision;
        this.city = city;
        this.zipCode = zipCode;
    }

}