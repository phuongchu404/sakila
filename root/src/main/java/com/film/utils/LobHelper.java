package com.film.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.sql.Blob;
@Service
public class LobHelper {
    private final Session session;
    public LobHelper(Session session) {
        this.session = session;
    }

    public Blob createBlob(InputStream content, long size) {
        return session.getLobHelper().createBlob(content, size);
    }
}
