package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public class PriceGroupRepositoryImplTest extends BaseRepositoryTest {

    @Autowired
    PriceGroupRepository priceGroupRepository;

    @Test
    public void testFindAllFetchLazy() throws Exception {
        Assert.assertNotNull(priceGroupRepository.findAllFetchLazy().get(0).getPrices().get(0));
    }

}