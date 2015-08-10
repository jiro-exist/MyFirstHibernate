package com.exist.manio.myfirsthibernate.infra.persistence;

public enum GenderEnum { 

	MALE("m"), 
	FEMALE("F");

	private String code;

	private GenderEnum(String code){
		this.code=code;
	}

	public String getCode() {
		return code;
	}

	public static GenderEnum getByCode(String code) {
	    for(GenderEnum e : values()) {
	        if(e.code.equals(code)) {
	        	return e;
	        }
	    }
	    return null;
	}

}