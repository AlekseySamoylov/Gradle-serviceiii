package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.work.WorkGroup;

import java.util.List;

/**
 * Created by alekseysamoylov on 11/13/16.
 *
 */
public interface WorkGroupRepositoryCustom {
    List<WorkGroup> findAllFetchLazy();

    WorkGroup findOneFetchLazy(Long id);
}
