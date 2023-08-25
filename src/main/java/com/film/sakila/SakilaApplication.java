package com.film.sakila;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@SpringBootApplication
@EnableTransactionManagement
public class SakilaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SakilaApplication.class, args);
    }
    @Bean
    public Session sessionFactory(EntityManager entityManager) {
        if (entityManager.unwrap(Session.class) == null) {
            throw new NullPointerException("EntityManagerFactory is not a Hibernate EntityManagerFactory");
        }
        return entityManager.unwrap(Session.class);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

}
