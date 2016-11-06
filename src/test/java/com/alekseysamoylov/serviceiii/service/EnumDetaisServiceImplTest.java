package com.alekseysamoylov.serviceiii.service;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
public class EnumDetaisServiceImplTest {
    @Test
    public void testGetEnumDetais() throws Exception {
        EnumDetailsService enumDetailsService = new EnumDetaisServiceImpl();
        Assert.assertTrue(enumDetailsService.getEnumDetais().size() > 0);
    }

}