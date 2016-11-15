package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.Work;
import com.alekseysamoylov.serviceiii.repository.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alekseysamoylov on 11/15/16.
 */
@Service
public class WorkServiceImpl implements WorkService {

    private WorkRepository workRepository;

    @Autowired
    public WorkServiceImpl(WorkRepository workRepository) {
        this.workRepository = workRepository;
    }

    @Override
    public Work save(Work work) {
        return workRepository.save(work);
    }

    @Override
    public Work findOne(Long id) {
        return workRepository.findOne(id);
    }
}
