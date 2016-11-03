package com.alekseysamoylov.serviceiii.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Getter
@Setter
public class CompanyPositionOnMap {
    private Long id;
    private String name;
    private String details;
    private double longitude;
    private double latitude;
    private List<CompanyType> companyTypeList;

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
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!getClass().isAssignableFrom(Hibernate.getClass(obj))) {
            return false;
        }

        CompanyPositionOnMap that = (CompanyPositionOnMap) obj;
        return null != this.getId() && this.getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode += null == getId() ? 0 : getId().hashCode() * 31;
        return hashCode;
    }

}
