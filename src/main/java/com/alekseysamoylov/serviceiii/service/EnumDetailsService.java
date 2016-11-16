package com.alekseysamoylov.serviceiii.service;

import java.util.Map;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Сервис для работы с перечислениями
 */
public interface EnumDetailsService {

    /**
     * @return Возвращает Map c названием елемента перечисления и соответствующим ему именем на языке пользователя
     */
    Map<String, String> getEnumDetails();
}
