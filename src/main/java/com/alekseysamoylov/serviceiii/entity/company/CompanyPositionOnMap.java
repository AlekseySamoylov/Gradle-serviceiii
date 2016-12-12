package com.alekseysamoylov.serviceiii.entity.company;


import com.alekseysamoylov.serviceiii.entity.AbstractSequenceIdEntity;
import com.alekseysamoylov.serviceiii.entity.CachableEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Позиция организации на карте
 */
@Getter
@Setter
@Entity
@Table(name = "company_position")
@JsonIgnoreProperties({
    "cacheNames"
})
public class CompanyPositionOnMap extends AbstractSequenceIdEntity implements Serializable, CachableEntity {


    public static final String CACHE_NAME = "companyPositionOnMap";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "details")
    private String details;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    @ElementCollection(targetClass = CompanyType.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "company_position_company_type",
            joinColumns = @JoinColumn(name = "company_position_id"))
    @Column(name = "company_type")
    @Enumerated(EnumType.STRING)
    private List<CompanyType> companyTypeList = new ArrayList<>();

    public CompanyPositionOnMap() {
    }


    public CompanyPositionOnMap(String name, String details, double longitude, double latitude, List<CompanyType> companyTypeList) {
        this.name = name;
        this.details = details;
        this.longitude = longitude;
        this.latitude = latitude;
        this.companyTypeList = companyTypeList;
    }

    @Override
    public String toString() {
        return "CompanyPositionOnMap{" +
                "id=" + super.getId() +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", companyTypeList=" + companyTypeList +
                '}';
    }
}
