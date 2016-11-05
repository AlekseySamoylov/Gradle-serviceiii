package com.alekseysamoylov.serviceiii.controller;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import com.alekseysamoylov.serviceiii.entity.Price;
import com.alekseysamoylov.serviceiii.entity.TestClass;
import com.alekseysamoylov.serviceiii.repository.TestCustomRepository;
import com.alekseysamoylov.serviceiii.service.CompanyPositionOnMapService;
import com.alekseysamoylov.serviceiii.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@Controller
public class WelcomeController {

    private PriceService priceService;
    private CompanyPositionOnMapService companyPositionOnMapService;
    private TestCustomRepository testCustomRepository;

    @Autowired
    public WelcomeController(
            PriceService priceService,
            CompanyPositionOnMapService companyPositionOnMapService,
            TestCustomRepository testCustomRepository) {
        this.priceService = priceService;
        this.companyPositionOnMapService = companyPositionOnMapService;
        this.testCustomRepository = testCustomRepository;
    }

    @RequestMapping(value = "/")
    public String goWelcome() {
        return "index";
    }

    @CrossOrigin
    @RequestMapping(value = "/prices")
    @ResponseBody
    public List<Price> getPrices() {
        return priceService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/coordinates")
    @ResponseBody
    public List<CompanyPositionOnMap> getCoordinates() {
        return companyPositionOnMapService.findAll();
    }


    @CrossOrigin
    @RequestMapping(value = "/test")
    @ResponseBody
    public List<TestClass> getTestObjects() {
        return testCustomRepository.findAll();
    }

}
