package com.film.sakila.service.impl;

import com.film.sakila.data.ActorParticipatedMoreThanTwentyFilms;
import com.film.sakila.data.InformationActor;
import com.film.sakila.repository.ActorRepository;
import com.film.sakila.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
