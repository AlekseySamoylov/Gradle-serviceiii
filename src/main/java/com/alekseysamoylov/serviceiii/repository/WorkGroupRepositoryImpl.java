package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.QWork;
import com.alekseysamoylov.serviceiii.entity.QWorkGroup;
import com.alekseysamoylov.serviceiii.entity.WorkGroup;
import com.alekseysamoylov.serviceiii.repository.querydsl.QueryDslMetadata;
import com.alekseysamoylov.serviceiii.repository.querydsl.QueryDslRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 *
 */
@Service
@Repository
@Transactional
public class WorkGroupRepositoryImpl implements WorkGroupRepositoryCustom {

    private QueryDslRepository queryDslRepository;

    @Autowired
    public WorkGroupRepositoryImpl(QueryDslRepository queryDslRepository) {
        this.queryDslRepository = queryDslRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<WorkGroup> findAllFetchLazy() {
        QWorkGroup qWorkGroup = QWorkGroup.workGroup;
        QWork qWork = QWork.work;
        QueryDslMetadata metadata = new QueryDslMetadata();
        metadata.from(qWorkGroup);
        metadata.leftJoin(qWorkGroup.works, qWork).fetch();

        return queryDslRepository.findAll(metadata, qWorkGroup);
    }

    @Override
    @Transactional(readOnly = true)
    public WorkGroup findOneFetchLazy(Long id) {
        QWorkGroup qWorkGroup = QWorkGroup.workGroup;
        QWork qWork = QWork.work;
        QueryDslMetadata metadata = new QueryDslMetadata();
        metadata.from(qWorkGroup);
        metadata.leftJoin(qWorkGroup.works, qWork).fetch();
        metadata.where(qWorkGroup.id.eq(id));

        return queryDslRepository.findOne(metadata, qWorkGroup);
    }

}
