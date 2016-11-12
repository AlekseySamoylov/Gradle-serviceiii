package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.WorkGroup;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface WorkGroupRepository {
    List<WorkGroup> findAllFetchLazy();
}
