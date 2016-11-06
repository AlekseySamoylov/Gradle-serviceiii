package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.PriceGroup;
import com.alekseysamoylov.serviceiii.repository.PriceGroupRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@CommonsLog
@Service
@CacheConfig(cacheNames = PriceGroup.CACHE_NAME)
public class PriceGroupServiceImpl implements PriceGroupService {

    private PriceGroupRepository priceGroupRepository;

    @Autowired
    public PriceGroupServiceImpl(PriceGroupRepository priceGroupRepository) {
        this.priceGroupRepository = priceGroupRepository;
    }

    @Override
    @Cacheable
    public List<PriceGroup> findAllFetchLazy() {
        return priceGroupRepository.findAllFetchLazy();
    }
}
