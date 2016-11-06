package com.alekseysamoylov.serviceiii.util;

import org.apache.commons.lang3.Validate;

/**
 * Вспомогательный класс для работы с {@link CustomIntegerEnum}.
 */
public class EnumUtils {
    /**
     * Возвращает значение перечислимого типа, реализующего интерфейс {@link CustomIntegerEnum},
     * по его целочисленному значению.
     *
     * @param enumClass класс перечислимого типа, реализующего интерфейс {@link CustomIntegerEnum}
     * @param value     целочисленное значение элемента перечислимого типа
     * @param <T>       перечислимый тип
     * @return значение перечислимого типа или {@code null}, если значения, соответствующего {@code value}, нет
     * @throws IllegalArgumentException если {@code enumClass} не является перечислимым
     */
    public static <T extends CustomIntegerEnum> T getEnum(Class<T> enumClass, int value) {
        Validate.isAssignableFrom(Enum.class, enumClass);

        for (T enumValue : enumClass.getEnumConstants()) {
            if (enumValue.getId() == value) {
                return enumValue;
            }
        }
        return null;
    }
}
