package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс доступа к базе данных для {@link User}.
 */
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
}
