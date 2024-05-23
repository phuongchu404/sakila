package com.film.request;

import lombok.Data;

@Data
public class InsertAddressRequest {
    private String address;
    private String district;
    private int cityId;
    private String phone;
    private String location;
}
