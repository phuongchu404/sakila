package com.film.sakila.service.impl;

import com.film.sakila.coverter.RatingEnumConverter;
import com.film.sakila.data.actor.ActorParticipatedMoreThanTwentyFilms;
import com.film.sakila.data.actor.InformationActor;
import com.film.sakila.data.actor.RevenueByActor;
import com.film.sakila.repository.ActorRepository;
import com.film.sakila.service.ActorService;
import com.film.sakila.status.RatingEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    public ActorServiceImpl(ActorRepository actorRepository){
        this.actorRepository = actorRepository;
    }
    @Override
    public List<InformationActor> getFirstAndLastNameActor() {
        return actorRepository.getFirstAndLastNameActor();
    }
    @Override
    public Page<ActorParticipatedMoreThanTwentyFilms> actorParticipatedMoreThanTwentyFilms(int pageNo, int pageSize) {
        PageRequest pageRequest= PageRequest.of(pageNo, pageSize);
        Page<ActorParticipatedMoreThanTwentyFilms> page =  actorRepository.actorParticipatedMoreThanTwentyFilms(pageRequest);
        return page;
    }

    @Override
    public List<String> getNameParticitingAtLeastOneMovie() {
        List<String> list = actorRepository.getNameParticipatingAtLeastOneMovie();
        return list;
    }

    @Override
    public List<RevenueByActor> getRevenueByActor() {
        List<RevenueByActor> list = actorRepository.getRevenueByActor();
        return list;
    }

    @Override
    public List<String> getNameActor(String rating, String notRating) {
        RatingEnumConverter ratingEnumConverter = new RatingEnumConverter();
        try{
            RatingEnum ratingConvert= ratingEnumConverter.convertToEntityAttribute(rating);
            RatingEnum notRatingConvert = ratingEnumConverter.convertToEntityAttribute(notRating);
            List<String> list = actorRepository.getNameActor(ratingConvert, notRatingConvert);
            return list;
        }catch (IllegalAccessError ex){
            ex.printStackTrace();
            return null;
        }

    }

}
