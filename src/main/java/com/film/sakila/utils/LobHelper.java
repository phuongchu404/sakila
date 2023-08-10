package com.film.sakila.utils;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.Blob;
@Service
public class LobHelper {
    private final SessionFactory sessionFactory;
    public LobHelper(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Blob createBlob(InputStream content, long size) {
        return sessionFactory.getCurrentSession().getLobHelper().createBlob(content, size);
    }
}
