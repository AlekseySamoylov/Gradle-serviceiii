package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public class WorkGroupRepositoryImplTest extends BaseRepositoryTest {

    @Autowired
    WorkGroupRepository workGroupRepository;

    @Test
    public void testFindAllFetchLazy() throws Exception {
        Assert.assertNotNull(workGroupRepository.findAllFetchLazy().get(0).getWorks().get(0));
    }

    @Test
    public void testFindAll() throws Exception {
        Assert.assertNotNull(workGroupRepository.findAll());
    }

}