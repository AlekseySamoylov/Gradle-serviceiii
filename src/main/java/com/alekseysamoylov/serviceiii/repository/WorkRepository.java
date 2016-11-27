package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.Work;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Репозиторий Работ {@link Work}
 */
public interface WorkRepository extends JpaRepository<Work, Long> {

    /**
     * Возвращает список работ определенной группы
     *
     * @param id группы работ
     * @return список работ определенной группы
     */
    List<Work> findByWorkGroupId(Long id);
}
