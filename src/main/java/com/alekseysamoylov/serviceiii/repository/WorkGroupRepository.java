package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.work.WorkGroup;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 *
 */
public interface WorkGroupRepository extends JpaRepository<WorkGroup, Long>, WorkGroupRepositoryCustom {
}
