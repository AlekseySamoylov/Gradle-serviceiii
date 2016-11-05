package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.TestClass;
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
public class TestCustomRepositoryImpl implements TestCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

//    @Autowired
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }

    @Override
    @Transactional(readOnly = true)
    public List<TestClass> findAll() {
        return entityManager.createNamedQuery("TestClass.findAll", TestClass.class).getResultList();
    }

    @Override
    public TestClass findOne(Long id) {
        return entityManager.find(TestClass.class, id);
    }
}
