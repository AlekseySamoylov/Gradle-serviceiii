package com.alekseysamoylov.serviceiii.service;

/**
 * Сервис для работы кэшем.
 */
public interface CacheService {
    /**
     * Очистить все кэши
     */
    void clearAllCaches();

    /**
     * Очистка перечисленый кешей
     *
     * @param names - названия кешей
     */
    void clearCaches(String... names);

}
