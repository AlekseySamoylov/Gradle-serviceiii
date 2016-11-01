package com.alekseysamoylov.serviceiii.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Getter
@Setter
public class CompanyPositionOnMap {
    private String name;
    private double longitude;
    private double latitude;

    public CompanyPositionOnMap() {
    }

    public CompanyPositionOnMap(String name, double longitude, double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
