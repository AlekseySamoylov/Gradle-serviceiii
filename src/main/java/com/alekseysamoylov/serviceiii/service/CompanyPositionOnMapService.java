package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 *
 */
public interface CompanyPositionOnMapService {

    /**
     * @return Возвращает список расположений компаний на карте
     */
    List<CompanyPositionOnMap> findAll();
}
