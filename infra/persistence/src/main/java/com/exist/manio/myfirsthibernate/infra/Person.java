package com.exist.manio.myfirsthibernate.infra.persistence;

public class Person {

	int id;
	String firstName;
	String middleName;
	String lastName;

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

	public Person() {

	}

	public Person(String firstName, String middleName, String lastName) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

}