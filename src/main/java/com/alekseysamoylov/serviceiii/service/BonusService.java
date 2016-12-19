package com.alekseysamoylov.serviceiii.service;

/**
 * Сервис для работы с сущностью {@link com.alekseysamoylov.serviceiii.entity.bonus.Bonus}
 */
public interface BonusService {

    /**
     * Возвращает сумму накопленных баллов пользователя округляя до целого числа.
     *
     * @param userId идентификатор пользователя
     * @return сумма накопленных баллов пользователя
     */
    Integer getBonusSumForUser(Long userId);
}
