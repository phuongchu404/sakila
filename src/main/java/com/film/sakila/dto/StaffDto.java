package com.film.sakila.dto;

import com.film.sakila.entity.Address;
import com.film.sakila.entity.Store;
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
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer addressId;
    private String email;
    private Integer storeId;
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
    public StaffDto() {

    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }
    public void setAddressId(Address address){
        this.addressId =  address.getId();
    }
    public void setStoreId(Store store){
        this.storeId = store.getId();
    }
    //    private OutputStream outputStream;
}
