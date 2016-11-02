package com.alekseysamoylov.serviceiii.entity;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Класс предоставляет MessageSource с человекочитаемыми названиями Enum типов модуля sipsga
 */

public abstract class EnumMessageSource {

    public static final MessageSource MESSAGE_SOURCE;

    static {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(ClassUtils.getPackageName(EnumMessageSource.class) + ".entities");
        MESSAGE_SOURCE = messageSource;
    }

    /**
     * Метод получения человекочитабельного названия Enum типа
     *
     * @param item элемент Enum
     * @return название элемента
     */
    public static String getName(Enum item) {
        return MESSAGE_SOURCE.getMessage(ClassUtils.getShortClassName(item.getClass()) + "." + item.name(), null, null);
    }

}
