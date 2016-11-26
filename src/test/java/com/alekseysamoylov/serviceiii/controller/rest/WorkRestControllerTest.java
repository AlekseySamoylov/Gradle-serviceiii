package com.alekseysamoylov.serviceiii.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * Created by alekseysamoylov on 11/26/16.
 */
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/spring-mvc-config.xml",
        "file:src/main/webapp/WEB-INF/spring/spring-core-config.xml"
})
@WebAppConfiguration
public class WorkRestControllerTest extends AbstractTestNGSpringContextTests {

    private MockMvc mockMvc;

    @Autowired
    private WorkRestController workRestController;

    @BeforeMethod
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(workRestController).build();

    }

    @Test
    public void testSaveWork() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/rest/works/2"))
                .andExpect(status().isOk());
        System.out.println("Hello");
    }

}