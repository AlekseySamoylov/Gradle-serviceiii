package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.reference.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с сущностью Клиент {@link com.alekseysamoylov.serviceiii.entity.reference.Customer}
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
