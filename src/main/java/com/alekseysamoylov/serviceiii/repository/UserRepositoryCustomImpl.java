package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.security.QRole;
import com.alekseysamoylov.serviceiii.entity.security.QUser;
import com.alekseysamoylov.serviceiii.entity.security.QUserRole;
import com.alekseysamoylov.serviceiii.entity.security.User;
import com.alekseysamoylov.serviceiii.repository.querydsl.QueryDslMetadata;
import com.alekseysamoylov.serviceiii.repository.querydsl.QueryDslRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by alekseysamoylov on 12/12/16.
 */
@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    private QueryDslRepository queryDslRepository;

    @Autowired
    public UserRepositoryCustomImpl(QueryDslRepository queryDslRepository) {
        this.queryDslRepository = queryDslRepository;
    }

    @Override
    public User findOneByUsernameFetchLazy(String username) {
        QUser qUser = QUser.user;
        QUserRole qUserRole = QUserRole.userRole;
        QRole qRole = QRole.role;

        QueryDslMetadata metadata = new QueryDslMetadata();
        metadata.from(qUser);
        metadata.leftJoin(qUser.userRoles, qUserRole).fetch();
        metadata.leftJoin(qUserRole.role, qRole).fetch();
        metadata.where(qUser.username.eq(username));

        return queryDslRepository.findOne(metadata, qUser);
    }
}
