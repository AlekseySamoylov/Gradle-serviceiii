package com.alekseysamoylov.serviceiii.service;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-core-config-test.xml"})
public class CompanyPositionOnMapServiceImplTest {

    @Autowired
    CompanyPositionOnMapService companyPositionOnMapService;

    @Test
    public void testFindAll() throws Exception {
        List<CompanyPositionOnMap> companyPositionOnMapList = companyPositionOnMapService.findAll();
    }

}