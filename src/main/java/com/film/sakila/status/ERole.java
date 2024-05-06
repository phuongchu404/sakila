package com.film.sakila.status;

public enum ERole {
    USER("USER"),
    MANAGER("MANAGER"),
        ADMIN("ADMIN");
    private    String value;
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    ERole(String value){
        this.value = value;
    }
}
