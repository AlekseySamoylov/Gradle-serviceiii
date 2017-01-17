package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.work.Work;
import com.alekseysamoylov.serviceiii.entity.work.WorkGroup;
import com.alekseysamoylov.serviceiii.repository.WorkRepository;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Реализация {@link WorkService}
 */
@CommonsLog
@Service
@CacheConfig(cacheNames = Work.CACHE_NAME)
public class WorkServiceImpl implements WorkService {

    private WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    @CacheEvict(value = {WorkGroup.CACHE_NAME, Work.CACHE_NAME}, allEntries = true) // чистим кэш для групп работ
    public Work save(Work work) {
        return workRepository.saveAndFlush(work);
    }

    @Override
    @CacheEvict(value = {WorkGroup.CACHE_NAME, Work.CACHE_NAME}, allEntries = true) // чистим кэш для групп работ
    public void update(Work work, Long id) {
        Work workInDb = workRepository.findOne(id);
        workInDb.setTitle(work.getTitle());
        workInDb.setPrice(work.getPrice());
        workInDb.setDetails(work.getDetails());
        workRepository.saveAndFlush(workInDb);
    }

    @Override
    @CacheEvict(value = {WorkGroup.CACHE_NAME, Work.CACHE_NAME}, allEntries = true) // чистим кэш для групп работ
    public void delete(Long id) {
        workRepository.delete(id);
    }

    @Override
    @Cacheable
    public Work findOne(Long id) {
        return workRepository.findOne(id);
    }

    @Override
    @Cacheable
    public List<Work> findByWorkGroupId(Long id) {
        return workRepository.findByWorkGroupId(id);
    }
}
