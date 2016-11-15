package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.Work;

/**
 * Created by alekseysamoylov on 11/15/16.
 */
public interface WorkService {
    Work save(Work work);

    Work findOne(Long id);
}
