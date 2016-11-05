package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@ContextConfiguration("classpath:spring-core-config-test.xml")
public class CompanyPositionOnMapRepositoryImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private CompanyPositionOnMapRepository companyPositionOnMapRepository;

    @Test
    public void testFindAll() throws Exception {
        System.out.println(companyPositionOnMapRepository.findAll());
    }

}