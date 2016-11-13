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
    // private WorkGroupRepositoryCustom workGroupRepositoryCustom;

    @Autowired
    public WorkGroupServiceImpl(WorkGroupRepository workGroupRepository
                                //, WorkGroupRepositoryCustom workGroupRepositoryCustom
    ) {
        this.workGroupRepository = workGroupRepository;
        // this.workGroupRepositoryCustom = workGroupRepositoryCustom;
    }

    @Override
    @Cacheable
    public List<WorkGroup> findAllFetchLazy() {
        return workGroupRepository.findAllFetchLazy();

        //  return workGroupRepositoryCustom.findAllFetchLazy();
    }

    @Override
    @Cacheable
    public List<WorkGroup> findAll() {
        return workGroupRepository.findAll();
    }
}
