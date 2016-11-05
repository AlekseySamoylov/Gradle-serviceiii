package com.alekseysamoylov.serviceiii.repository;

import com.alekseysamoylov.serviceiii.entity.TestClass;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public interface TestCustomRepository {
    public List<TestClass> findAll();

    public TestClass findOne(Long id);
}
