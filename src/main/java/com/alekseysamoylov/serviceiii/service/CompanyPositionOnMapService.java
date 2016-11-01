package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface CompanyPositionOnMapService {
    List<CompanyPositionOnMap> findAll();
}
