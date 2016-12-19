package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by alekseysamoylov on 12/19/16.
 */
public class BonusRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private BonusRepository bonusRepository;

    @Test
    public void testFindByUserId() throws Exception {
        System.out.println(bonusRepository.findByUserId(1L));
    }

}