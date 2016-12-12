package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.security.User;

/**
 * Дополнительный интерфейс репозитория по работе c пользователями
 */
public interface UserRepositoryCustom {

    /**
     * Возвращает пользователя по его логину
     * со всеми Lazy полями
     *
     * @param username логин пользователя
     * @return пользователь
     */
    User findOneByUsernameFetchLazy(String username);
}
