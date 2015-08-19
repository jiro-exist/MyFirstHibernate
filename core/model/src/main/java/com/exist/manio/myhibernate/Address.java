package com.exist.manio.myfirsthibernate.core.model;

public class Address {

    private int id;
    private String houseNumber;
    private String street;
    private String barangay;
    private String subdivision;
    private String city;
    private String zipCode;
    private Person person;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getHouseNumber() {
        return this.houseNumber;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return this.street;
    }

    public void setBarangay(String barangay) {
        this.barangay = barangay;
    }

    public String getBarangay() {
        return this.barangay;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getSubdivision() {
        return this.subdivision;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return this.zipCode;
    }

    public void setPerson(Person person) {
        if(person != null) {
            this.person = person;
        }
    }

    public Person getPerson() {
        return this.person;
    }

    public String toString() {
        return  "HouseNumber:" + houseNumber + "\n"
              + "Street:" + street + "\n"
              + "Barangay:" + barangay + "\n"
              + "Subdivision:" + subdivision + "\n"
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