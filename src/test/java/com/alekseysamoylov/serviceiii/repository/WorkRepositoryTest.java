package com.alekseysamoylov.serviceiii.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

/**
 * Created by alekseysamoylov on 11/27/16.
 */
public class WorkRepositoryTest extends BaseRepositoryTest {

    @Autowired
    private WorkRepository workRepository;

    @Test
    public void testFindByWorkGroupId() throws Exception {
        workRepository.findByWorkGroupId(1L);
    }

}