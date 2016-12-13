package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by alekseysamoylov on 12/12/16.
 */
public class UserRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByUsernameFetchLazy() {
        System.out.println("hello " + userRepository.findOneByUsernameFetchLazy("user"));
    }

}