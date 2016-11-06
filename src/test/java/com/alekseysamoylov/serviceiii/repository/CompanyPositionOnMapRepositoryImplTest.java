package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public class CompanyPositionOnMapRepositoryImplTest extends BaseRepositoryTest {

    @Autowired
    private CompanyPositionOnMapRepository companyPositionOnMapRepository;

    @Test
    public void testFindAll() throws Exception {
        Assert.assertTrue(companyPositionOnMapRepository.findAll().size() > 0);
    }

}