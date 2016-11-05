package com.alekseysamoylov.serviceiii.entity;

import org.apache.commons.lang3.ClassUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Класс предоставляет MessageSource с человекочитаемыми названиями Enum
 */

public abstract class EnumMessageSource {

    public static final MessageSource MESSAGE_SOURCE;

    static {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("locales.enums");
        MESSAGE_SOURCE = messageSource;
    }

    /**
     * Метод получения человекочитабельного названия Enum типа
     *
     * @param item элемент Enum
     * @return название элемента
     */
    public static String getName(Enum item) {
        String shortClassName = ClassUtils.getShortClassName(item.getClass());
        String code = shortClassName + "." + item.name();
        return MESSAGE_SOURCE.getMessage(code, null, null);
    }

}
