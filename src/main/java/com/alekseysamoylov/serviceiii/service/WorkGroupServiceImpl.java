package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.WorkGroup;
import com.alekseysamoylov.serviceiii.repository.WorkGroupRepository;
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
@CacheConfig(cacheNames = WorkGroup.CACHE_NAME)
public class WorkGroupServiceImpl implements WorkGroupService {

    private WorkGroupRepository workGroupRepository;

    @Autowired
    public WorkGroupServiceImpl(WorkGroupRepository workGroupRepository) {
        this.workGroupRepository = workGroupRepository;
    }

    @Override
    @Cacheable
    public List<WorkGroup> findAllFetchLazy() {
        return workGroupRepository.findAllFetchLazy();

    }

    @Override
    @Cacheable
    public List<WorkGroup> findAll() {
        return workGroupRepository.findAll();
    }

    @Override
    @Cacheable
    public WorkGroup findOneFetchLazy(Long id) {
        return workGroupRepository.findOneFetchLazy(id);
    }
}
