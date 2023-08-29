package com.film.sakila.service.impl;

import com.film.sakila.coverter.RatingEnumConverter;
import com.film.sakila.coverter.SpecialFeatureEnumConverter;
import com.film.sakila.data.AverageRentalByCategory;
import com.film.sakila.data.TopFiveFilm;
import com.film.sakila.dto.FilmDto;
import com.film.sakila.entity.Film;
import com.film.sakila.entity.Language;
import com.film.sakila.repository.FilmRepository;
import com.film.sakila.repository.LanguageRepository;
import com.film.sakila.service.FilmService;
import com.film.sakila.status.RatingEnum;
import com.film.sakila.status.SpecialFeatureEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmRepository filmRepository;

    @Autowired
    private LanguageRepository languageRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public List<FilmDto> getTitleRateCost() {
        List<Film> films = filmRepository.findAll();
        return films.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public void insert(String title, int languageId, String rating, Set<String> specialFeature) {
        RatingEnumConverter ratingEnumConverter = new RatingEnumConverter();
        SpecialFeatureEnumConverter specialFeatureEnumConverter = new SpecialFeatureEnumConverter();
        Language language = languageRepository.findById(languageId).orElseThrow(()-> new IllegalArgumentException("Language not found"));
        RatingEnum ratingEnum = ratingEnumConverter.convertToEntityAttribute(rating);
        String stringspecialFeature = String.join(",", specialFeature);
        Set<SpecialFeatureEnum> specialFeatureEnums = specialFeatureEnumConverter.convertToEntityAttribute(stringspecialFeature);
        Film film = new Film();
        film.setTitle(title);
        film.setLanguage(language);
        film.setRating(ratingEnum);
        film.setSpecialFeatures(specialFeatureEnums);
        filmRepository.save(film);
    }

    @Override
    public List<TopFiveFilm> getTopFiveFilm() {
        List<TopFiveFilm> films = filmRepository.getTopFiveFilm();
        return films;
    }

    @Override
    public List<AverageRentalByCategory> averageRentalByCategory(int pageNo, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by("name"));
        Sort sort = Sort.by("avgRental").descending();
        List<AverageRentalByCategory> page = filmRepository.averageRentalByCategory().stream().sorted(Comparator.comparingDouble((AverageRentalByCategory o1)->o1.getAvgRental()).reversed()).collect(Collectors.toList());
        return page;
    }

//    @Override
//    public List<FilmDto> getAll() {
//        List<Film> filmEntities = filmRepository.findAll();
//        return filmEntities.stream().map(item->{
//            Set<String> specialFeatureEnums = item.getSpecialFeatures().stream().map(c->c.getValue()).collect(Collectors.toSet());
//            return new FilmDto(item.getId(), item.getTitle(), item.getDescription(),
//                    item.getReleaseYear(), item.getLanguage().getId(), item.getRentalDuration(), item.getRentalRate(), item.getLength(),
//                    item.getReplacementCost(), item.getRating().getValue(), specialFeatureEnums, item.getLastUpdate());
//        }).collect(Collectors.toList());
//    }

    private FilmDto convertToDto(Film film){
        FilmDto filmDto = modelMapper.map(film, FilmDto.class);
        Set<String> specialFeature = film.getSpecialFeatures().stream().map(SpecialFeatureEnum::getValue).collect(Collectors.toSet());
        filmDto.setSpecialFeatures(specialFeature);
        return filmDto;
    }
    private Film convertToEntity(FilmDto filmDto){
        Film film = modelMapper.map(filmDto, Film.class);
        return film;
    }
}
