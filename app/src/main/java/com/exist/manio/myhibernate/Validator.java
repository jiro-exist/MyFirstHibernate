package com.exist.manio.myfirsthibernate.app;

import org.apache.commons.validator.routines.DateValidator;
import java.text.SimpleDateFormat;

public class Validator {

	public static boolean validateDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
        	formatter.parse(date);
        }
        catch (Exception e) {
			System.out.println("parse false");
        	return false;
        }
		System.out.println(formatter.toPattern());

		DateValidator validator = DateValidator.getInstance();
		if (validator.validate(date,formatter.toPattern()) != null) {
		// if (validator.isValid(date)) {
			System.out.println("true");
		    return true;
		} else {
			System.out.println("false");
		    return false;
		}
	}

}