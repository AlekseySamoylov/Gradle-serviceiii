package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.company.CompanyPositionOnMap;
import com.alekseysamoylov.serviceiii.repository.CompanyPositionOnMapRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@CommonsLog
@Service
@CacheConfig(cacheNames = CompanyPositionOnMap.CACHE_NAME)
public class CompanyPositionOnMapServiceImpl implements CompanyPositionOnMapService {

    private CompanyPositionOnMapRepository companyPositionOnMapRepository;

    @Autowired
    public CompanyPositionOnMapServiceImpl(CompanyPositionOnMapRepository companyPositionOnMapRepository) {
        this.companyPositionOnMapRepository = companyPositionOnMapRepository;
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable
    public List<CompanyPositionOnMap> findAll() {
        return companyPositionOnMapRepository.findAll();
    }
}
