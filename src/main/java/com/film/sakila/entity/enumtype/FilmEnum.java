package com.film.sakila.entity.enumtype;

public enum FilmEnum {
    G("G"),PG("PG"), PG_13("PG-13"), R("R"), NC_17("NC-17");
    private String value;

    public String getValue(){
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    FilmEnum(String value){
        this.value =  value;
    }
}
