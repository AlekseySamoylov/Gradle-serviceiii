package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.work.Work;

import java.util.List;

/**
 * Created by alekseysamoylov on 11/15/16.
 * Сервис для сущности Работа {@link Work}
 */
public interface WorkService {

    /**
     * Сохраняет новую Работу или обновляет существующую Работу и возвращает ее с присвоенным id
     *
     * @param work новая работа
     * @return новая работа с присвоенным id
     */
    Work save(Work work);

    /**
     * Обновляет работу
     *
     * @param work работа
     * @param id   идентификатор работы
     * @return работа
     */
    void update(Work work, Long id);

    /**
     * Удаляет работу
     *
     * @param id работы
     */
    void delete(Long id);

    /**
     * Возвращает работу по id
     * @param id работы
     * @return работа {@link Work}
     */
    Work findOne(Long id);

    /**
     * Возвращает список работ, определенной группы
     *
     * @param id группы работ
     * @return список работ, определенной группы
     */
    List<Work> findByWorkGroupId(Long id);
}
