package com.film.sakila.service.impl;

import com.film.sakila.coverter.RatingEnumConverter;
import com.film.sakila.coverter.SpecialFeatureEnumConverter;
import com.film.sakila.dto.FilmDto;
import com.film.sakila.entity.FilmEntity;
import com.film.sakila.entity.LanguageEntity;
import com.film.sakila.repository.FilmRepository;
import com.film.sakila.repository.LanguageRepository;
import com.film.sakila.service.FilmService;
import com.film.sakila.status.RatingEnum;
import com.film.sakila.status.SpecialFeatureEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;
    @Override
    public List<String> getTitle() {
        List<FilmEntity> list = filmRepository.findAll();
        return list.stream()
                .map(FilmEntity::getRating).
                map(RatingEnum::getValue).
                collect(Collectors.toList());
    }

    @Override
    public void insert(String title, int languageId, String rating, Set<String> specialFeature) {
        RatingEnumConverter ratingEnumConverter = new RatingEnumConverter();
        SpecialFeatureEnumConverter specialFeatureEnumConverter = new SpecialFeatureEnumConverter();
        LanguageEntity language = languageRepository.findById(languageId).orElseThrow(()-> new IllegalArgumentException("Language not found"));
        RatingEnum ratingEnum = ratingEnumConverter.convertToEntityAttribute(rating);
        String stringspecialFeature = String.join(",", specialFeature);
        Set<SpecialFeatureEnum> specialFeatureEnums = specialFeatureEnumConverter.convertToEntityAttribute(stringspecialFeature);
        FilmEntity film = new FilmEntity();
        film.setTitle(title);
        film.setLanguage(language);
        film.setRating(ratingEnum);
        film.setSpecialFeatures(specialFeatureEnums);
        filmRepository.save(film);
    }

    @Override
    public List<FilmDto> getAll() {
        List<FilmEntity> filmEntities = filmRepository.findAll();
        return filmEntities.stream().map(item->{
            Set<String> specialFeatureEnums = item.getSpecialFeatures().stream().map(c->c.getValue()).collect(Collectors.toSet());
            return new FilmDto(item.getId(), item.getTitle(), item.getDescription(),
                    item.getReleaseYear(), item.getLanguage().getId(), item.getRentalDuration(), item.getRentalRate(), item.getLength(),
                    item.getReplacementCost(), item.getRating().getValue(), specialFeatureEnums, item.getLastUpdate());
        }).collect(Collectors.toList());
    }
}
