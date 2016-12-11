package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.security.User;

/**
 * Сервис для работы с пользователями.
 */
public interface UserService {

    /**
     * Возвращает пользователя по его логину
     *
     * @param username логин пользователя
     * @return пользователь
     */
    User findByUsername(String username);
}
