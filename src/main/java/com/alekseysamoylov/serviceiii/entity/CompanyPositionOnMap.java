package com.alekseysamoylov.serviceiii.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

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
@NamedQueries({
        @NamedQuery(name = "CompanyPositionOnMap.findAll", query = "select c from CompanyPositionOnMap c")
})
@JsonIgnoreProperties({
    "cacheNames"
})
public class CompanyPositionOnMap implements Serializable, CachableEntity {


    public static final String CACHE_NAME = "companyPositionOnMap";

    @Override
    public String[] getCacheNames() {
        return new String[]{CACHE_NAME};
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
        hashCode += null == getId() ? 0 : getId().hashCode() * 35;
        return hashCode;
    }

    @Override
    public String toString() {
        return "CompanyPositionOnMap{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", companyTypeList=" + companyTypeList +
                '}';
    }
}
