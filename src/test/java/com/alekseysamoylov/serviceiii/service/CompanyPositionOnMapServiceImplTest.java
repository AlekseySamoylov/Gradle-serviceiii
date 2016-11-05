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
public class CompanyPositionOnMapServiceImplTest extends AbstractTestNGSpringContextTests {


    @Autowired
    CompanyPositionOnMapService companyPositionOnMapService;

    @Test
    public void testFindAll() throws Exception {
        System.out.println(companyPositionOnMapService);
        List<CompanyPositionOnMap> companyPositionOnMapList = companyPositionOnMapService.findAll();
        System.out.println(companyPositionOnMapList.get(0).getCompanyTypeList().get(0).getName());
    }

}