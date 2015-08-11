package com.exist.manio.myfirsthibernate.core.model;

public enum GenderEnum { 

    MALE("m","male"), 
    FEMALE("f","female");

    private String code;
    private String description;

    private GenderEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static GenderEnum getByCode(String code) {
        for(GenderEnum e : values()) {
            if(e.code.equals(code.toLowerCase())) {
                return e;
            }
        }
        return null;
    }

}