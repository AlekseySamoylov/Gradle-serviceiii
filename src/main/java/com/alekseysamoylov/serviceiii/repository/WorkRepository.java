package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by alekseysamoylov on 11/15/16.
 *
 */
public interface WorkRepository extends JpaRepository<Work, Long> {
}
