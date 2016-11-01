package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Service
public class CompanyPositionOnMapServiceImpl implements CompanyPositionOnMapService {
    @Override
    public List<CompanyPositionOnMap> findAll() {
        List<CompanyPositionOnMap> companies = new ArrayList<>();
        companies.add(new CompanyPositionOnMap("First", 55.323423, 53.234324));
        companies.add(new CompanyPositionOnMap("Second", 55.323523, 53.234424));
        companies.add(new CompanyPositionOnMap("Third", 55.323493, 53.234394));
        return companies;
    }
}
