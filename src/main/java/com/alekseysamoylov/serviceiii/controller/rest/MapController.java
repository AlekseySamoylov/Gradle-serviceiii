package com.alekseysamoylov.serviceiii.controller.rest;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import com.alekseysamoylov.serviceiii.service.CompanyPositionOnMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by alekseysamoylov on 11/19/16.
 */
@RestController
@RequestMapping(value = "/rest")
public class MapController {

    private CompanyPositionOnMapService companyPositionOnMapService;

    @Autowired
    public MapController(CompanyPositionOnMapService companyPositionOnMapService) {
        this.companyPositionOnMapService = companyPositionOnMapService;
    }

    @CrossOrigin
    @RequestMapping(value = "/coordinates")
    public List<CompanyPositionOnMap> findCoordinates() {
        return companyPositionOnMapService.findAll();
    }

}
