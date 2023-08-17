package com.film.sakila.service.impl;

import com.film.sakila.data.FirstAndLastNameActor;
import com.film.sakila.repository.ActorRepository;
import com.film.sakila.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    private ActorRepository actorRepository;
    @Override
    public List<FirstAndLastNameActor> getFirstAndLastNameActor() {
        return actorRepository.getFirstAndLastNameActor();
    }
}
