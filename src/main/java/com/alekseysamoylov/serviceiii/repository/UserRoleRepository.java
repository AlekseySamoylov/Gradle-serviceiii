package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.security.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для работы с таблицей Многие ко Многим Пользователь-Роль
 */
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}
