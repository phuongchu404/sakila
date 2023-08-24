package com.film.sakila.dto;

import lombok.Data;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class StaffDto {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
    private int id;
    private String firstName;
    private String lastName;
    private int addressId;
    private String email;
    private int storeId;
    private String userName;
    private byte[] picture;
    private String lastUpdate;

    public StaffDto(int id, String firstName, String lastName, int addressId, String email,
                    int storeId, String userName, byte[] picture, Date lastUpdate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressId = addressId;
        this.email = email;
        this.storeId = storeId;
        this.userName = userName;
        this.picture = picture;
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }
//    private OutputStream outputStream;
}
