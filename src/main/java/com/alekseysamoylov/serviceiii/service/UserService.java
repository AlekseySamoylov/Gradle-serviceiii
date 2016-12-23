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

    /**
     * Сохраняет нового пользователя
     *
     * @param user пользователь
     * @return id пользователя
     */
    Long save(User user);

    /**
     * Проверяет, есть ли пользователь с данным логином и паролем
     * и возвращает id при обнаружении
     *
     * @param user пользователь
     * @return id пользователя
     */
    Long login(User user);
}
