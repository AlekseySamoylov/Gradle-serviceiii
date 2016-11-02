package com.alekseysamoylov.serviceiii.util;

/**
 * Интерфейс для Enum классов, идентифицируемых по числовому идентификатору.
 * Должен применяться, когда значение enum нельзя представить как {@link javax.persistence.EnumType#ORDINAL}
 */

public interface CustomIntegerEnum {

    /**
     * Возвращает id перечислимого типа
     */
    int getId();

    /**
     * Возвращает описание перечислимого типа.
     */
    String getName();

}
