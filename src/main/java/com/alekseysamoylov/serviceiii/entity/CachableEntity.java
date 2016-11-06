package com.alekseysamoylov.serviceiii.entity;

/**
 * Интерфейс для кэшируемых справочников
 */
public interface CachableEntity {
    /**
     * Массив имен кешей: самого кеша и зависимых кешей
     */
    String[] getCacheNames();

}
