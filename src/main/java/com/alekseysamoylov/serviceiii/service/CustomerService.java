package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.reference.Customer;

/**
 * Сервис для работы с сущностью Клиент {@link com.alekseysamoylov.serviceiii.entity.reference.Customer}
 */
public interface CustomerService {

    /**
     * Сохраняет объекты {@link Customer}  и {@link com.alekseysamoylov.serviceiii.entity.security.User}
     * хэшируя пароль пользователя
     * устанавливает роль Клиент (@link ROLE_CUSTOMER)
     * и возвращает идентификатор пользователя.
     *
     * @param customer пользователь с заполненным полем User
     * @return id User'a
     */
    Long saveCustomerAndGetUserId(Customer customer);
}
