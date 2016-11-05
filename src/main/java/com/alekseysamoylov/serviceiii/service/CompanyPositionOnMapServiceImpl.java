package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import com.alekseysamoylov.serviceiii.repository.CompanyPositionOnMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Service
public class CompanyPositionOnMapServiceImpl implements CompanyPositionOnMapService {

    private CompanyPositionOnMapRepository companyPositionOnMapRepository;

    @Autowired
    public CompanyPositionOnMapServiceImpl(CompanyPositionOnMapRepository companyPositionOnMapRepository) {
        this.companyPositionOnMapRepository = companyPositionOnMapRepository;
    }

    @Override
    public List<CompanyPositionOnMap> findAll() {
//        List<CompanyPositionOnMap> companies = new ArrayList<>();
//        companies.add(new CompanyPositionOnMap("First", "Hello world", 55.323423, 53.234324, new ArrayList<CompanyType>(Arrays.asList(CompanyType.CAR_SERVICE))));
//        companies.add(new CompanyPositionOnMap("Second", "Hello world", 55.323523, 53.234424, new ArrayList<CompanyType>(Arrays.asList(CompanyType.CAR_WASH))));
//        companies.add(new CompanyPositionOnMap("Third", "Hello world", 55.323493, 53.234394, new ArrayList<CompanyType>(Arrays.asList(CompanyType.TIRE_SERVICE))));
//        System.out.println("Hello");
//        return companies;
        return companyPositionOnMapRepository.findAll();
    }
}
