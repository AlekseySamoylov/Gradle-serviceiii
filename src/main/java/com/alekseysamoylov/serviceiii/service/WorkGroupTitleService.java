package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.model.WorkGroupTitle;

import java.util.List;

/**
 * Created by alekseysamoylov on 11/12/16.
 * Сервис для работы с названиями групп услуг / работ
 */
public interface WorkGroupTitleService {

    /**
     * @return Возвращает все названия групп работ с соответствующими id
     */
    List<WorkGroupTitle> findAll();
}
