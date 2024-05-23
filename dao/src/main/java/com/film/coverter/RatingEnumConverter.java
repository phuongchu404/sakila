package com.film.coverter;

import com.film.status.RatingEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class RatingEnumConverter implements AttributeConverter<RatingEnum, String> {
    @Override
    public String convertToDatabaseColumn(RatingEnum ratingEnum) {
        if(ratingEnum==null){
            return null;
        }
        return ratingEnum.getValue();
    }

    @Override
    public RatingEnum convertToEntityAttribute(String s) {
        if(s==null){
            return null;
        }
        return Stream.of(RatingEnum.values()).
                filter((c->c.getValue().equals(s))).
                findFirst().
                orElseThrow(IllegalAccessError::new);
    }
}
