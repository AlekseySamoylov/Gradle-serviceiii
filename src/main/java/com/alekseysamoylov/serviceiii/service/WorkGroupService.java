package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.WorkGroup;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Сервис для работы с группами услуг / работ
 */
public interface WorkGroupService {

    /**
     * @return Возвращает все группы работ со всеми ленивыми полями
     */
    List<WorkGroup> findAllFetchLazy();

    /**
     * @return Возвращает все группы работ
     */
    List<WorkGroup> findAll();
}
