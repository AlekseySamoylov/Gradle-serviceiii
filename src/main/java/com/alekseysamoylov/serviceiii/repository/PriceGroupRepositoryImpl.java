package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.PriceGroup;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Service
@Transactional
public class PriceGroupRepositoryImpl implements PriceGroupRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<PriceGroup> findAllFetchLazy() {
        return entityManager.createNamedQuery("PriceGroup.findAllFetchLazy", PriceGroup.class).getResultList();
    }
}
