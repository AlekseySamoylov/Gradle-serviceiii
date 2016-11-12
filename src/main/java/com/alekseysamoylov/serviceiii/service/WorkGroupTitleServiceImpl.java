package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.WorkGroup;
import com.alekseysamoylov.serviceiii.model.WorkGroupTitle;
import com.alekseysamoylov.serviceiii.repository.WorkGroupRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alekseysamoylov on 11/12/16.
 */
@Service
@CommonsLog
@CacheConfig(cacheNames = WorkGroup.CACHE_NAME)
public class WorkGroupTitleServiceImpl implements WorkGroupTitleService {

    private WorkGroupRepository workGroupRepository;

    @Autowired
    public WorkGroupTitleServiceImpl(WorkGroupRepository workGroupRepository) {
        this.workGroupRepository = workGroupRepository;
    }

    @Override
    public List<WorkGroupTitle> findAll() {
        List<WorkGroup> workGroupList = workGroupRepository.findAll();
        List<WorkGroupTitle> workGroupTitleServiceList = new ArrayList<>();
        workGroupList.forEach(workGroup -> {
            workGroupTitleServiceList.add(new WorkGroupTitle(workGroup.getId(), workGroup.getTitle()));
        });
        return workGroupTitleServiceList;
    }
}
