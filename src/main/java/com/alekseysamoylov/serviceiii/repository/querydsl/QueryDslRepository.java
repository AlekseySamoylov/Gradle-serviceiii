package com.alekseysamoylov.serviceiii.repository.querydsl;

import com.mysema.query.Tuple;
import com.mysema.query.types.Expression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.io.Serializable;
import java.util.List;

/**
 * Интерфейс для выполнения запросов с помощью <a href="http://www.querydsl.com/">Querydsl</a>.
 */
public interface QueryDslRepository {
    /**
     * Находит один объект, удовлетворяющий запросу, заданному {@link QueryDslMetadata}.
     *
     * @param metadata   запрос, которому должен удовлетворять найденный объект
     * @param domainType тип возвращаемого объекта
     * @return найденный объект
     * @throws com.mysema.query.NonUniqueResultException если запрос вернул более одного результата
     */
    public <T> T findOne(QueryDslMetadata metadata, Expression<T> domainType);

    /**
     * Находит объединение объектов разных сущностей, удовлетворяющее запросу, заданному {@link QueryDslMetadata}.
     *
     * @param metadata    запрос, которому должно удовлетворять найденное объединение
     * @param domainTypes типы возвращаемых объектов
     * @return найденное объединение
     * @throws com.mysema.query.NonUniqueResultException если запрос вернул более одного результата
     */
    public Tuple findOne(QueryDslMetadata metadata, Expression<?>... domainTypes);

    /**
     * Находит сущность требуемого типа по ее идентификатору.
     *
     * @param id         идентификатор сущности
     * @param domainType класс требуемой сущности
     * @return найденную сущность или {@code null}, если сущности с требуемым идентификатором нет
     */
    public <T> T findOne(Serializable id, Class<T> domainType);

    /**
     * Находит сущность требуемого типа по ее идентификатору.
     *
     * @param id         идентификатор сущности
     * @param domainType наименование класса требуемой сущности
     * @return найденную сущность или {@code null}, если сущности с требуемым идентификатором нет
     */
    public <T> T findOne(Serializable id, String domainType);

    /**
     * Находит все объекты, удовлетворяющие запросу, заданному {@link QueryDslMetadata}.
     *
     * @param metadata   запрос, которому должны удовлетворять найденные объекты
     * @param domainType тип возвращаемых объектов
     * @return найденные объекты
     */
    public <T> List<T> findAll(QueryDslMetadata metadata, Expression<T> domainType);

    /**
     * Находит все объекты, удовлетворяющие запросу, заданному {@link QueryDslMetadata} и блокирует их.
     *
     * @param metadata   запрос, которому должны удовлетворять найденные объекты
     * @param lockMode   требуемый тип блокировки найденных объектов
     * @param domainType тип возвращаемых объектов
     * @return найденные объекты
     */
    public <T> List<T> findAll(QueryDslMetadata metadata, LockModeType lockMode,
                               Expression<T> domainType);

    /**
     * Находит все объединения объектов разных сущностей, удовлетворяющие запросу, заданному {@link QueryDslMetadata}.
     *
     * @param metadata    запрос, которому должны удовлетворять найденные объединения
     * @param domainTypes типы возвращаемых объектов
     * @return найденные объединения
     */
    public List<Tuple> findAll(QueryDslMetadata metadata, Expression<?>... domainTypes);

    /**
     * Находит все объединения объектов разных сущностей, удовлетворяющие запросу, заданному {@link QueryDslMetadata},
     * располагающиеся на указанной странице.
     *
     * @param metadata    запрос, которому должны удовлетворять найденные объединения
     * @param pageable    информация о странице данных
     * @param domainTypes типы возвращаемых объектов
     * @return страница с найденными объектами
     */
    public Page<Tuple> findAll(QueryDslMetadata metadata, Pageable pageable, Expression<?>... domainTypes);

    /**
     * Возвращает число результатов запроса, заданного {@link QueryDslMetadata}.
     *
     * @param metadata запрос, число результатов которого ищется
     */
    long count(QueryDslMetadata metadata);

    /**
     * Удаляет сущность.
     *
     * @param entity удаляемая сущность
     */
    public <T> void delete(T entity);

    /**
     * Сохраняет сущность.
     *
     * @param entity сохраняемая сущность
     * @return обновленная сущность
     */
    public <T> T save(T entity);

    /**
     * Сохраняет несколько сущностей.
     *
     * @param entities сохраняемые сущности
     * @return обновленные сущности
     */
    public <T> List<T> save(Iterable<T> entities);

    /**
     * Сохраняет сущность и сразу выполняет запросы в базе данных.
     *
     * @param entity сохраняемая сущность
     * @return обновленная сущность
     * @see javax.persistence.EntityManager#flush()
     */
    public <T> T saveAndFlush(T entity);

    /**
     * Обновляет сотстояние сущности из базы данных.
     *
     * @param entity сущность, которая должна быть обновлена
     * @see javax.persistence.EntityManager#refresh(Object)
     */
    public void refresh(Object entity);

    /**
     * Блокирует сущность в соответствии с указанным типом блокировки.
     *
     * @param entity   сущность, которая должна быть блокирована
     * @param lockMode требуемый тип блокировки
     * @see javax.persistence.EntityManager#lock(Object, javax.persistence.LockModeType)
     */
    public void lock(Object entity, LockModeType lockMode);

    /**
     * Удаляет сущность из контекста {@link javax.persistence.EntityManager}.
     *
     * @param entity сущность, которая должна быть удалена из контекста
     * @see javax.persistence.EntityManager#detach(Object)
     */
    public void detach(Object entity);

    /**
     * Выполняет переданный JPA Query
     *
     * @param query
     */
    public void executeUpdateQuery(String query);

    public EntityManager getEntityManager();
}

