package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.bonus.Bonus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Доступ к сущности {@link Bonus}
 */
public interface BonusRepository extends JpaRepository<Bonus, Long> {

    /**
     * Возвращает список Бонусов пользователя
     *
     * @param userId идентификатор пользователя
     * @return список Бонусов пользователя
     */
    List<Bonus> findByUserId(Long userId);

}
