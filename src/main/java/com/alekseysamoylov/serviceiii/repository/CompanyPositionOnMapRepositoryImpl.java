package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Service
@Repository
@Transactional
public class CompanyPositionOnMapRepositoryImpl implements CompanyPositionOnMapRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public List<CompanyPositionOnMap> findAll() {
        List<CompanyPositionOnMap> companies = entityManager.createNamedQuery("CompanyPositionOnMap.findAll", CompanyPositionOnMap.class).getResultList();
        return companies;
    }
}
