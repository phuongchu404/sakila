package com.film.coverter;

import com.film.status.SpecialFeatureEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SpecialFeatureEnumConverter implements AttributeConverter<Set<SpecialFeatureEnum>, String> {
    @Override
    public String convertToDatabaseColumn(Set<SpecialFeatureEnum> specialFeatureEnum) {
        if(specialFeatureEnum==null){
            return null;
        }
        Set<String> stringSet = specialFeatureEnum.stream().map(c->c.getValue()).collect(Collectors.toSet());

        return String.join(",", stringSet);
    }

    @Override
    public Set<SpecialFeatureEnum> convertToEntityAttribute(String strings) {
        if(strings==null) return null;
        Set<SpecialFeatureEnum> specialFeatures = new HashSet<>();
        String[] stringSet = strings.split(",");
        Stream.of(stringSet).forEach(item->{
            SpecialFeatureEnum specialFeatureEnum = Stream.of(SpecialFeatureEnum.values())
                    .filter(c->c.getValue().equals(item)).
                    findFirst().orElseThrow(IllegalAccessError::new);
            specialFeatures.add(specialFeatureEnum);
        });
        return specialFeatures;
    }


}
