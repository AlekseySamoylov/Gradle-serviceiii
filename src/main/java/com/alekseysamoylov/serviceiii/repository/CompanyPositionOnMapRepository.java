package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface CompanyPositionOnMapRepository {

    List<CompanyPositionOnMap> findAll();
}
