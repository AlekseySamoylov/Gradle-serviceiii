package com.alekseysamoylov.serviceiii.repository.querydsl;

import com.mysema.query.QueryMetadata;
import com.mysema.query.Tuple;
import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Expression;
import org.apache.commons.lang3.ClassUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.querydsl.SimpleEntityPathResolver;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Repository
public class QueryDslRepositoryImpl implements QueryDslRepository {
    private static final EntityPathResolver DEFAULT_ENTITY_PATH_RESOLVER = SimpleEntityPathResolver.INSTANCE;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public <T> T findOne(QueryDslMetadata metadata, Expression<T> domainType) {
        JPAQuery query = createJpaQuery(metadata.getMetadata());
        return query.uniqueResult(domainType);
    }

    @Override
    @Transactional(readOnly = true)
    public Tuple findOne(QueryDslMetadata metadata, Expression<?>... domainTypes) {
        JPAQuery query = createJpaQuery(metadata.getMetadata());
        return query.uniqueResult(domainTypes);
    }

    @Override
    @Transactional(readOnly = true)
    public <T> T findOne(Serializable id, Class<T> entityClass) {
        return entityManager.find(entityClass, id);
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public <T> T findOne(Serializable id, String domainType) {
        try {
            return (T) entityManager.find(ClassUtils.getClass(domainType), id);
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Class " + domainType + " not found", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public <T> List<T> findAll(QueryDslMetadata metadata, Expression<T> domainType) {
        JPAQuery query = createJpaQuery(metadata.getMetadata());
        return query.list(domainType);
    }

    @Override
    @Transactional(readOnly = true)
    public <T> List<T> findAll(QueryDslMetadata metadata, LockModeType lockMode, Expression<T> domainType) {
        JPAQuery query = createJpaQuery(metadata.getMetadata()).setLockMode(lockMode);
        return query.list(domainType);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Tuple> findAll(QueryDslMetadata metadata, Expression<?>... domainTypes) {
        JPAQuery query = createJpaQuery(metadata.getMetadata());
        return query.list(domainTypes);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Tuple> findAll(QueryDslMetadata querydslMetadata, Pageable pageable, Expression<?>... domainTypes) {
        // клонируем данных запроса, т.к. сортировка на странице меняет данные запроса,
        // пришедшие извне (добавляется order by)
        QueryMetadata newMetadata = querydslMetadata.getMetadata().clone();
        JPAQuery countQuery = createJpaQuery(newMetadata);
        long total = countQuery.count();
        JPAQuery query = createJpaQuery(newMetadata);

        applyPagination(pageable, query);

        // TODO: I.Zadorozhny: сортировку для страницы пропускаем для случая
        // когда возвращается набор сущностей разного типа, в связи с тем что
        // это не реализовано в querydsl, а сделать самому не просто.

        List<Tuple> content = total > pageable.getOffset() ? query.list(domainTypes) : Collections.<Tuple>emptyList();
        return new PageImpl<Tuple>(content, pageable, total);
    }

    @Override
    @Transactional(readOnly = true)
    public long count(QueryDslMetadata querydslMetadata) {
        JPAQuery countQuery = createJpaQuery(querydslMetadata.getMetadata());
        return countQuery.count();
    }

    @Override
    @Transactional
    public <T> void delete(T entity) {
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    @SuppressWarnings("unchecked")
    public <T> T save(T entity) {
        JpaEntityInformation<T, ?> entityInformation =
                new JpaMetamodelEntityInformation(entity.getClass(), entityManager.getMetamodel());
        if (entityInformation.isNew(entity)) {
            entityManager.persist(entity);
            return entity;
        } else {
            return entityManager.merge(entity);
        }
    }

    @Transactional
    public <T> List<T> save(Iterable<T> entities) {

        List<T> result = new ArrayList<T>();

        if (entities == null) {
            return result;
        }

        for (T entity : entities) {
            result.add(save(entity));
        }

        return result;
    }

    @Override
    @Transactional
    public <T> T saveAndFlush(T entity) {
        T result = save(entity);
        entityManager.flush();
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public void refresh(Object entity) {
        entityManager.refresh(entity);
    }

    @Override
    public void lock(Object entity, LockModeType lockMode) {
        entityManager.lock(entity, lockMode);
    }

    @Override
    public void detach(Object entity) {
        entityManager.detach(entity);
    }

    @Override
    @Transactional
    public void executeUpdateQuery(String query) {
        entityManager.createQuery(query).executeUpdate();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public EntityManager getEntityManager() {
        return entityManager;
    }


    private JPAQuery createJpaQuery(QueryMetadata metadata) {
        return new JPAQuery(entityManager, metadata);
    }


    private void applyPagination(Pageable pageable, JPQLQuery query) {
        query.offset(pageable.getOffset());
        query.limit(pageable.getPageSize());
    }
}

