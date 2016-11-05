package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@ContextConfiguration("classpath:spring-core-config-test.xml")
public class TestRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    TestCustomRepository testRepository;

    @Test
    public void testMethod() {
        System.out.println(testRepository.findOne(1L));
        System.out.println(testRepository.findAll());
    }

}