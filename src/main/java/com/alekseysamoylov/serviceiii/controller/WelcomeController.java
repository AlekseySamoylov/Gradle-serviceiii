package com.alekseysamoylov.serviceiii.controller;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import com.alekseysamoylov.serviceiii.entity.TestClass;
import com.alekseysamoylov.serviceiii.repository.TestCustomRepository;
import com.alekseysamoylov.serviceiii.service.CompanyPositionOnMapService;
import com.alekseysamoylov.serviceiii.service.EnumDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Controller
public class WelcomeController {

    private CompanyPositionOnMapService companyPositionOnMapService;
    private TestCustomRepository testCustomRepository;
    private EnumDetailsService enumDetailsService;

    @Autowired
    public WelcomeController(
            CompanyPositionOnMapService companyPositionOnMapService,
            TestCustomRepository testCustomRepository,
            EnumDetailsService enumDetailsService) {
        this.companyPositionOnMapService = companyPositionOnMapService;
        this.testCustomRepository = testCustomRepository;
        this.enumDetailsService = enumDetailsService;
    }

    @RequestMapping(value = "/")
    public String goWelcome() {
        return "index";
    }

    @CrossOrigin
    @RequestMapping(value = "/coordinates")
    @ResponseBody
    public List<CompanyPositionOnMap> getCoordinates() {
        return companyPositionOnMapService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/enums")
    @ResponseBody
    public Map<String, String> getEnumDetails() {
        return enumDetailsService.getEnumDetais();
    }


    @CrossOrigin
    @RequestMapping(value = "/test")
    @ResponseBody
    public List<TestClass> getTestObjects() {
        return testCustomRepository.findAll();
    }

}
