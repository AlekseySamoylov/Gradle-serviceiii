package com.alekseysamoylov.serviceiii.controller;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import com.alekseysamoylov.serviceiii.entity.WorkGroup;
import com.alekseysamoylov.serviceiii.model.WorkGroupTitle;
import com.alekseysamoylov.serviceiii.service.CompanyPositionOnMapService;
import com.alekseysamoylov.serviceiii.service.EnumDetailsService;
import com.alekseysamoylov.serviceiii.service.WorkGroupService;
import com.alekseysamoylov.serviceiii.service.WorkGroupTitleService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 */
@RestController
@CommonsLog
public class WorkRestController {

    private CompanyPositionOnMapService companyPositionOnMapService;
    private EnumDetailsService enumDetailsService;
    private WorkGroupService workGroupService;
    private WorkGroupTitleService workGroupTitleService;

    @Autowired
    public WorkRestController(CompanyPositionOnMapService companyPositionOnMapService,
                              EnumDetailsService enumDetailsService,
                              WorkGroupService workGroupService,
                              WorkGroupTitleService workGroupTitleService) {
        this.companyPositionOnMapService = companyPositionOnMapService;
        this.enumDetailsService = enumDetailsService;
        this.workGroupService = workGroupService;
        this.workGroupTitleService = workGroupTitleService;
    }


    @CrossOrigin
    @RequestMapping(value = "/coordinates")
    public List<CompanyPositionOnMap> getCoordinates() {
        return companyPositionOnMapService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/enums")
    public Map<String, String> getEnumDetails() {
        return enumDetailsService.getEnumDetais();
    }

    @CrossOrigin
    @RequestMapping(value = "/works")
    public List<WorkGroup> getWorks() {
        return workGroupService.findAllFetchLazy();
    }

    @CrossOrigin
    @RequestMapping(value = "/prices")
    public List<WorkGroup> getPrices() {
        return workGroupService.findAllFetchLazy();
    }

    @CrossOrigin
    @RequestMapping(value = "/workGroups")
    @Transactional
    public List<WorkGroupTitle> getWorkGroups() {
        return workGroupTitleService.findAll();
    }


}
