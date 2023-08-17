package com.film.sakila.entity.enumtype;

public enum SpecialFeatureEnum {
    Trailers("Trailers"),
    Commentaries("Commentaries"),
    DeletedScenes("Deleted Scenes"),
    BehindTheScenes("Behind the Scenes");
    private String value;

    public String getValue() {
        return value;
    }
    public void setValue(String value){
        this.value = value;
    }
    SpecialFeatureEnum(String value){
        this.value = value;
    }

}
