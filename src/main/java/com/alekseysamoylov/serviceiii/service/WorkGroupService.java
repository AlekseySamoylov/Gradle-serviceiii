package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.WorkGroup;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface WorkGroupService {
    List<WorkGroup> findAllFetchLazy();

    List<WorkGroup> findAll();
}
