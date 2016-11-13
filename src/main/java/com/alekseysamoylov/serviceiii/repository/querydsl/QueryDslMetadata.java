package com.alekseysamoylov.serviceiii.repository.querydsl;


import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.QueryMetadata;
import com.mysema.query.jpa.JPAQueryMixin;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.*;
import lombok.Getter;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Сериализуемая обертка над {@link QueryMetadata} необходимая для формирования {@link JPAQuery}. Присоединение таблиц
 * при помощи join можно выполнять, только если соответствующая связь прописана в сущности. Например,
 * <pre>
 * QueryDslMetadata metadata = new QueryDslMetadata();
 * QUserDepartment department = new QUserDepartment("dep");
 * metadata.from(QUser.user)
 *     .leftJoin(QUser.user.userDepartments, department)
 *     .leftJoin(QUserDepartment.userDepartment.pk.department)
 *     .where(QUser.user.username.eq(&quot;userWithoutDepartment&quot;));
 * User userWithoutDepartment = queryDslRepository.findOne(metadata, QUser.user);
 * </pre>
 */
public class QueryDslMetadata implements Serializable {
    /**
     * Не сериализуемое поле. предоставляющее некоторые специальные функции для изменения поля QueryMetadata metadata
     */
    private transient final JPAQueryMixin<?> queryMixin;
    @Getter
    private final QueryMetadata metadata;

    /**
     * Конструктор по умолчанию.
     */
    public QueryDslMetadata() {
        this(new DefaultQueryMetadata());
    }

    /**
     * Создает новый экземпляр класса по заданному экэемляру {@link QueryMetadata}.
     */
    public QueryDslMetadata(QueryMetadata metadata) {
        Validate.notNull(metadata);
        this.metadata = metadata;
        queryMixin = new JPAQueryMixin<Object>(metadata);
    }

    /**
     * Объявляет сущность, из которой будет происходить запрос (т.е. сущность, которая будет
     * находиться после оператора <tt>from</tt> в SQL-запросе).
     *
     * @param arg сущность
     * @see com.mysema.query.jpa.JPAQueryMixin#from(com.mysema.query.types.Expression)
     */
    public final QueryDslMetadata from(Expression<?> arg) {
        queryMixin.from(arg);
        return this;
    }

    /**
     * Объявляет сущности, из которых будет происходить запрос (т.е. те сущности, которые будут
     * находиться после оператора <tt>from</tt> в SQL-запросе).
     *
     * @param args список сущностей
     * @see com.mysema.query.jpa.JPAQueryMixin#from(com.mysema.query.types.Expression[])
     */
    public final QueryDslMetadata from(Expression<?>... args) {
        queryMixin.from(args);
        return this;
    }

    /**
     * Добавляет свойство <tt>fetch</tt> к последнему <tt>join</tt>.
     */
    public final QueryDslMetadata fetch() {
        queryMixin.fetch();
        return this;
    }

    /**
     * Добавляет свойство <tt>fetch</tt> ко всем <tt>join</tt>.
     */
    public final QueryDslMetadata fetchAll() {
        queryMixin.fetchAll();
        return this;
    }

    /**
     * Добавляет <tt>join</tt> с заданной сущностью.
     *
     * @param target cущность, связь c которой надо добавить
     * @see com.mysema.query.jpa.JPAQueryMixin#join(com.mysema.query.types.Expression)
     */
    public final <P> QueryDslMetadata join(Expression<P> target) {
        queryMixin.join(target);
        return this;
    }

    /**
     * Добавляет <tt>join</tt> с заданной cущностью и используемым именем сущности в запросе.
     *
     * @param target cущность, связь c которой надо добавить
     * @param alias  имя сущности в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#join(com.mysema.query.types.Expression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata join(Expression<P> target, Path<P> alias) {
        queryMixin.join(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>join</tt> со свойством типа {@link java.util.Collection}.
     *
     * @param target свойство, связь с которой надо добавить
     * @param alias  имя свойства в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#join(com.mysema.query.types.CollectionExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata join(CollectionExpression<?, P> target, Path<P> alias) {
        queryMixin.join(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>join</tt> со свойством типа {@link java.util.Map}.
     *
     * @param target свойство, связь с которой надо добавить
     * @param alias  имя свойства в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#join(com.mysema.query.types.MapExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata join(MapExpression<?, P> target, Path<P> alias) {
        queryMixin.join(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>join</tt> с подзапросом.
     *
     * @param target подзапрос, связь с которой надо добавить
     * @param alias  имя подзапроса в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#join(com.mysema.query.types.SubQueryExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata join(SubQueryExpression<P> target, Path<?> alias) {
        queryMixin.join(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>left join</tt> с заданной сущностью.
     *
     * @param target cущность, связь c которой надо добавить
     * @see com.mysema.query.jpa.JPAQueryMixin#leftJoin(com.mysema.query.types.Expression)
     */
    public final <P> QueryDslMetadata leftJoin(Expression<P> target) {
        queryMixin.leftJoin(target);
        return this;
    }

    /**
     * Добавляет <tt>left join</tt> с заданной cущностью и используемым именем сущности в запросе.
     *
     * @param target cущность, связь c которой надо добавить
     * @param alias  имя сущности в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#leftJoin(com.mysema.query.types.Expression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata leftJoin(Expression<P> target, Path<P> alias) {
        queryMixin.leftJoin(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>left join</tt> со свойством типа {@link java.util.Collection}.
     *
     * @param target свойство, связь с которой надо добавить
     * @param alias  имя свойства в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#leftJoin(com.mysema.query.types.CollectionExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata leftJoin(CollectionExpression<?, P> target, Path<P> alias) {
        queryMixin.leftJoin(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>left join</tt> со свойством типа {@link java.util.Map}.
     *
     * @param target свойство, связь с которой надо добавить
     * @param alias  имя свойства в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#leftJoin(com.mysema.query.types.MapExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata leftJoin(MapExpression<?, P> target, Path<P> alias) {
        queryMixin.leftJoin(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>left join</tt> с подзапросом.
     *
     * @param target подзапрос, связь с которой надо добавить
     * @param alias  имя подзапроса в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#leftJoin(com.mysema.query.types.SubQueryExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata leftJoin(SubQueryExpression<P> target, Path<?> alias) {
        queryMixin.leftJoin(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>inner join</tt> с заданной сущностью.
     *
     * @param target cущность, связь c которой надо добавить
     * @see com.mysema.query.jpa.JPAQueryMixin#innerJoin(com.mysema.query.types.Expression)
     */
    public final <P> QueryDslMetadata innerJoin(Expression<P> target) {
        queryMixin.innerJoin(target);
        return this;
    }

    /**
     * Добавляет <tt>inner join</tt> с заданной cущностью и используемым именем сущности в запросе.
     *
     * @param target cущность, связь c которой надо добавить
     * @param alias  имя сущности в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#innerJoin(com.mysema.query.types.Expression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata innerJoin(Expression<P> target, Path<P> alias) {
        queryMixin.innerJoin(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>inner join</tt> со свойством типа {@link java.util.Collection}.
     *
     * @param target свойство, связь с которой надо добавить
     * @param alias  имя свойства в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#innerJoin(com.mysema.query.types.CollectionExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata innerJoin(CollectionExpression<?, P> target, Path<P> alias) {
        queryMixin.innerJoin(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>inner join</tt> со свойством типа {@link java.util.Map}.
     *
     * @param target свойство, связь с которой надо добавить
     * @param alias  имя свойства в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#innerJoin(com.mysema.query.types.MapExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata innerJoin(MapExpression<?, P> target, Path<P> alias) {
        queryMixin.innerJoin(target, alias);
        return this;
    }

    /**
     * Добавляет <tt>inner join</tt> с подзапросом.
     *
     * @param target подзапрос, связь с которой надо добавить
     * @param alias  имя подзапроса в SQL-запросе
     * @see com.mysema.query.jpa.JPAQueryMixin#innerJoin(com.mysema.query.types.SubQueryExpression, com.mysema.query.types.Path)
     */
    public final <P> QueryDslMetadata innerJoin(SubQueryExpression<P> target, Path<?> alias) {
        queryMixin.innerJoin(target, alias);
        return this;
    }

    /**
     * Добавляет условие <tt>where</tt> в запрос.
     *
     * @param predicate предикат, задающий условие
     * @see com.mysema.query.jpa.JPAQueryMixin#where(com.mysema.query.types.Predicate)
     */
    public final QueryDslMetadata where(Predicate predicate) {
        queryMixin.where(predicate);
        return this;
    }

    /**
     * Добавляет условие <tt>where</tt> в запрос.
     *
     * @param predicates предикаты, задающие условие
     * @see com.mysema.query.jpa.JPAQueryMixin#where(com.mysema.query.types.Predicate...)
     */
    public final QueryDslMetadata where(Predicate... predicates) {
        queryMixin.where(predicates);
        return this;
    }

    /**
     * Добавляет условие <tt>having</tt> в запрос.
     *
     * @param predicate предикат, задающий условие
     * @see com.mysema.query.jpa.JPAQueryMixin#having(com.mysema.query.types.Predicate)
     */
    public final QueryDslMetadata having(Predicate predicate) {
        queryMixin.having(predicate);
        return this;
    }

    /**
     * Добавляет условие <tt>having</tt> в запрос.
     *
     * @param predicates предикаты, задающие условие
     * @see com.mysema.query.jpa.JPAQueryMixin#having(com.mysema.query.types.Predicate...)
     */
    public final QueryDslMetadata having(Predicate... predicates) {
        queryMixin.having(predicates);
        return this;
    }

    /**
     * Добавляет выражение <tt>group by</tt> в запрос.
     *
     * @param expression добавляемое выражение
     * @see com.mysema.query.jpa.JPAQueryMixin#groupBy(com.mysema.query.types.Expression)
     */
    public final QueryDslMetadata groupBy(Expression<?> expression) {
        queryMixin.groupBy(expression);
        return this;
    }

    /**
     * Добавляет выражения <tt>group by</tt> в запрос.
     *
     * @param expressions добавляемые выражения
     * @see com.mysema.query.jpa.JPAQueryMixin#groupBy(com.mysema.query.types.Expression[])
     */
    public final QueryDslMetadata groupBy(Expression<?>... expressions) {
        queryMixin.groupBy(expressions);
        return this;
    }

    /**
     * Добавляет выражение <tt>order by</tt> в запрос.
     *
     * @param spec добавляемое выражение
     * @see com.mysema.query.jpa.JPAQueryMixin#orderBy(com.mysema.query.types.OrderSpecifier)
     */
    public final QueryDslMetadata orderBy(OrderSpecifier<?> spec) {
        queryMixin.orderBy(spec);
        return this;
    }

    /**
     * Добавляет выражения <tt>order by</tt> в запрос.
     *
     * @param specs добавляемые выражения
     * @see com.mysema.query.jpa.JPAQueryMixin#orderBy(com.mysema.query.types.OrderSpecifier[])
     */
    public final QueryDslMetadata orderBy(OrderSpecifier<?>... specs) {
        queryMixin.orderBy(specs);
        return this;
    }

    /**
     * Добавляет условие <tt>on</tt> к последнему <tt>join</tt>.
     *
     * @param predicate предикат, задающий условие
     * @see com.mysema.query.jpa.JPAQueryMixin#on(com.mysema.query.types.Predicate)
     */
    public final QueryDslMetadata on(Predicate predicate) {
        queryMixin.on(predicate);
        return this;
    }

    /**
     * Добавляет выражение <tt>setDistinct</tt>
     *
     * @param distinct аргумент выражения <tt>setDistinct</tt>
     * @return
     */
    public final QueryDslMetadata setDistinct(boolean distinct) {
        queryMixin.setDistinct(distinct);
        return this;
    }

    /**
     * Добавляет условия <tt>on</tt> к последнему <tt>join</tt>.
     *
     * @param predicates предикаты, задающий условие
     * @see com.mysema.query.jpa.JPAQueryMixin#on(com.mysema.query.types.Predicate...)
     */
    public final QueryDslMetadata on(Predicate... predicates) {
        queryMixin.on(predicates);
        return this;
    }

    /**
     * Устанавливает количество записей в выборке.
     *
     * @see com.mysema.query.QueryMetadata#setLimit(Long)
     */
    public final void limit(long limit) {
        metadata.setLimit(limit);
    }

    /**
     * Устанавливает номер первой записи, которую должна вернуть выборка.
     *
     * @see com.mysema.query.QueryMetadata#setOffset(Long)
     */
    public final void offset(long offset) {
        metadata.setOffset(offset);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof QueryDslMetadata) {
            QueryDslMetadata q = (QueryDslMetadata) o;
            return q.metadata.equals(metadata);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return metadata.hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(metadata).toString();
    }
}

