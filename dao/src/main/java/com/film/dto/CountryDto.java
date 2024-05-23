package com.film.dto;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CountryDto {
    private Integer id;
    private String name;
    private String lastUpdate;
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }
}
