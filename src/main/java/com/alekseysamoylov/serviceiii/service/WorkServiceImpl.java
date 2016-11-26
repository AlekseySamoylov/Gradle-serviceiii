package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.Work;
import com.alekseysamoylov.serviceiii.entity.WorkGroup;
import com.alekseysamoylov.serviceiii.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

/**
 * Реализация {@link WorkService}
 */
@Service
public class WorkServiceImpl implements WorkService {

    private WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    @CacheEvict(value = WorkGroup.CACHE_NAME, allEntries = true) // чистим кэш для групп работ
    public Work save(Work work) {
        return workRepository.saveAndFlush(work);
    }

    @Override
    @CacheEvict(value = WorkGroup.CACHE_NAME, allEntries = true) // чистим кэш для групп работ
    public void delete(Long id) {
        workRepository.delete(id);
    }

    @Override
    public Work findOne(Long id) {
        return workRepository.findOne(id);
    }
}
