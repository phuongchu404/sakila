package com.film.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.locationtech.jts.geom.Point;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Data
public class AddressDto {
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int id;
    private String address;
    private String address2;
    private String district;
    private int cityId;
    private String postalCode;
    private String phone;
    private String location;
    private double locationX;
    private double locationY;
    private String lastUpdate;


    public AddressDto(int id, String address, String address2, String district, int cityId,
                      String postalCode, String phone, Point location, Date lastUpdate) throws ParseException {
        this.id = id;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.cityId = cityId;
        this.postalCode = postalCode;
        this.phone = phone;
        this.location = location.toString();
        this.locationX= location.getX();
        this.locationY = location.getY();
        this.lastUpdate = simpleDateFormat.format(lastUpdate);
    }

//    private byte[] decodeData(byte[] encodedData){
//        return Base64.getDecoder().decode(encodedData);
//    }
//
//    private String blobToString(Blob blob){
//        try {
//            byte[] blobData = blob.getBytes(1, (int)blob.length());
//            byte[] decodeBytes = Base64.getDecoder().decode(blobData);
//            String decodeString = new String(decodeBytes, StandardCharsets.UTF_8);
//            return decodeString;
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }


}
