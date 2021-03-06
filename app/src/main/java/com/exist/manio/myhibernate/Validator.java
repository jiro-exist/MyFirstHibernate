package com.exist.manio.myfirsthibernate.app;

import java.text.SimpleDateFormat;

import org.apache.commons.validator.routines.DateValidator;
import com.exist.manio.myfirsthibernate.core.model.GenderEnum;
import com.exist.manio.myfirsthibernate.core.model.Constants;


public class Validator {

    public static boolean isName(String str) {
        if ("".equals(str)) {
            return false;
        }
        // else {
        //   return str.matches("/^[a-z ,.'-]+$/i");
        // }
        return true;
    }

    public static boolean isBoolean(String str) {
    	str = str.toLowerCase();
    	switch (str) {

    		case "yes"	:
    		case "y"	:
    		case "n"	:
    		case "no"	:
    						return true;

    		default		:	return false;

    	}
    }
    
    public static boolean isInt(String str) {
        if ("".equals(str)) {
            return false;
        }
        else {
          return str.matches("\\d*");  //match an int
        }
    }

    public static boolean isInt(String str, int min, int max) {
        if ("".equals(str)) {
            return false;
        }
        else {
            if(str.matches("\\d*")) {
                if(Integer.parseInt(str) < min) {
                    return false;
                }
                if(Integer.parseInt(str) > max) {
                    return false;
                }

                return true;
            }
            else {
                return false;
            }
        }
    }

    public static boolean isNumeric(String str) {
        if ("".equals(str)) {
            return false;
        }
        else {
          return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal. Must start with 0 if only decimal eg 0.1
        }
    }

	public static boolean isDate(String date) {

        try {
        	Constants.DATEFORMAT.parse(date);
        }
        catch (Exception e) {
        	return false;
        }

		DateValidator validator = DateValidator.getInstance();
		if (validator.validate(date,Constants.DATEFORMAT.toPattern()) != null) {
		    return true;
		} else {
		    return false;
		}
	}

    public static boolean isGender(String gender) {
    	gender = gender.toLowerCase();
        if(GenderEnum.getByCode(gender) == null ) {
            return false;
        }
        return true;
    }


}