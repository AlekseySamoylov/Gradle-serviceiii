package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@ContextConfiguration("classpath:spring-core-config-test.xml")
public class CacheServiceImplTest extends AbstractTestNGSpringContextTests {

    @Autowired
    CompanyPositionOnMapService companyPositionOnMapService;

    @Autowired
    PriceGroupService priceGroupService;

    @Autowired
    CacheService cacheService;

    @Test
    public void priceGroupCacheTest() {
        for (int i = 0; i < 50; i++) {
            if (i == 25) {
                cacheService.clearAllCaches();
            }
            System.out.println(priceGroupService.findAllFetchLazy().get(0).getPrices().get(0));

        }
    }

    @Test
    public void testClearCaches() throws Exception {
        for (int i = 0; i < 50; i++) {
            if (i == 25) {
                cacheService.clearCaches(CompanyPositionOnMap.CACHE_NAME);
            }

            List<CompanyPositionOnMap> companyPositionOnMapList = companyPositionOnMapService.findAll();
            System.out.println(companyPositionOnMapList.get(0).getCompanyTypeList().get(0).getName());

        }
    }

}