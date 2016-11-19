package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.Work;

/**
 * Created by alekseysamoylov on 11/15/16.
 * Сервис для сущности Работа {@link Work}
 */
public interface WorkService {

    /**
     * Сохраняет новую Работу и возвращает ее с присвоенным id
     *
     * @param work новая работа
     * @return новая работа с присвоенным id
     */
    Work save(Work work);

    /**
     * Возвращает работу по id
     * @param id работы
     * @return работа {@link Work}
     */
    Work findOne(Long id);
}