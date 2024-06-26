package com.film.service.impl;

import com.film.entity.Film;
import com.film.entity.Language;
import com.film.repository.FilmRepository;
import com.film.repository.LanguageRepository;
import com.film.coverter.RatingEnumConverter;
import com.film.coverter.SpecialFeatureEnumConverter;
import com.film.data.film.AverageRentalByCategory;
import com.film.data.film.TopFiveFilm;
import com.film.dto.FilmDto;
import com.film.service.FilmService;
import com.film.status.RatingEnum;
import com.film.status.SpecialFeatureEnum;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public List<String> getTitleFilm(int length) {
        List<String> titles = filmRepository.getTitleFilm(length, RatingEnum.PG_13);
        return titles;
    }

    @Override
    public List<String> getTitleNotReturnDate() {
        List<String> titles = filmRepository.getTitleNotReturnDate();
        return titles;
    }

    @Override
    public List<String> getTitleRentedByMultipleCustomer(int count) {
        List<String> list = filmRepository.getTitleRentedByMultipleCustomer(count);
        return list;
    }

    @Override
    public Page<Film> getAll(int pageNo, int pageSize, String sortBy) {
//        Sort sort = Sort.by("title");
//        switch (sortBy){
//            case 1: sort = sort.descending(); break;
//            default:
//                sort = sort.ascending();
//                break;
//        }
        Sort sort = sortBy.equals(1) ? Sort.by("title").descending() : Sort.by("title").ascending();
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);
        return filmRepository.findAll(pageRequest);
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
