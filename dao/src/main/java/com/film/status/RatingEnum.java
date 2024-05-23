package com.film.status;


import java.util.stream.Stream;

public enum RatingEnum {
    G("G"),PG("PG"), PG_13("PG-13"), R("R"), NC_17("NC-17");

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    RatingEnum(String value){
        this.value =  value;
    }
//    public static RatingEnum of(String value){
//        return Stream.of(RatingEnum.values()).filter(c->c.getValue().equals(value)).findFirst().orElseThrow(IllegalAccessError::new);
//    }
}
