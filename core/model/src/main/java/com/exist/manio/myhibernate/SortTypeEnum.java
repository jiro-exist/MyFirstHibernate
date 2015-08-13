package com.exist.manio.myfirsthibernate.core.service;

public enum SortTypeEnum {

    ASCENDING("a"), 
    DESCENDING("d");

    private String code;

    private SortTypeEnum(String code){
        this.code=code;
    }

    public String getCode() {
        return code;
    }

    public static SortTypeEnum getByCode(String code) {
        for(SortTypeEnum e : values()) {
            if(e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}
