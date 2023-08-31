package com.film.sakila.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.film.sakila.common.Views;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CityDto {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @JsonView(Views.Internal.class)
    private int id;
    @JsonView(Views.Public.class)
    private String city;
    @JsonView(Views.Private.class)
    private String lastUpdate;
    @JsonView({Views.Public.class, Views.Private.class})
    private int countryId;



    public void setLastUpdate(Date lastUpdate){
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }

}
