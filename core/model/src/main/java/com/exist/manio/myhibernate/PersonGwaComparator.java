package com.exist.manio.myfirsthibernate.core.model;

import java.util.Comparator;

import com.exist.manio.myfirsthibernate.core.model.Person;

public class PersonGwaComparator implements Comparator<Person> {

    @Override
    public int compare(Person person1, Person person2) {
        return Double.compare(person1.getGwa(), person2.getGwa());
    }
    
}