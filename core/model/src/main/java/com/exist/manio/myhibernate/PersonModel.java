package com.exist.manio.myfirsthibernate.core.model;

import java.util.List;
import java.util.ArrayList;

import com.exist.manio.myfirsthibernate.infra.persistence.Person;

public class PersonModel {

	List<Person> personList;

	public PersonModel() {
		personList = new ArrayList<Person>();
	}

	public void setPersonList(List<Person> personList) {
		if(personList != null) {
			this.personList = personList;
		}
	}

	public List<Person> getPersonList() {
		return this.personList;
	}

}