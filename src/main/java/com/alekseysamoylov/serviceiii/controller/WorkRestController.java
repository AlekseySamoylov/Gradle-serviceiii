package com.alekseysamoylov.serviceiii.controller;

import com.alekseysamoylov.serviceiii.entity.CompanyPositionOnMap;
import com.alekseysamoylov.serviceiii.entity.Work;
import com.alekseysamoylov.serviceiii.entity.WorkGroup;
import com.alekseysamoylov.serviceiii.model.WorkGroupTitle;
import com.alekseysamoylov.serviceiii.service.*;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 * Контроллер Rest
 */
@RestController
@CommonsLog
@RequestMapping(value = "/rest")
public class WorkRestController {

    private CompanyPositionOnMapService companyPositionOnMapService;
    private EnumDetailsService enumDetailsService;
    private WorkGroupService workGroupService;
    private WorkGroupTitleService workGroupTitleService;
    private WorkService workService;

    @Autowired
    public WorkRestController(CompanyPositionOnMapService companyPositionOnMapService,
                              EnumDetailsService enumDetailsService,
                              WorkGroupService workGroupService,
                              WorkGroupTitleService workGroupTitleService,
                              WorkService workService) {
        this.companyPositionOnMapService = companyPositionOnMapService;
        this.enumDetailsService = enumDetailsService;
        this.workGroupService = workGroupService;
        this.workGroupTitleService = workGroupTitleService;
        this.workService = workService;
    }

    @CrossOrigin
    @RequestMapping(value = "/coordinates")
    public List<CompanyPositionOnMap> findCoordinates() {
        return companyPositionOnMapService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/enums")
    public Map<String, String> getEnumDetails() {
        return enumDetailsService.getEnumDetais();
    }

    @CrossOrigin
    @RequestMapping(value = "/works", method = RequestMethod.GET)
    public List<WorkGroup> findWorks() {
        return workGroupService.findAllFetchLazy();
    }

    @CrossOrigin
    @RequestMapping(value = "/work/{workId}", method = RequestMethod.GET)
    public Work findWork(@PathVariable Long workId) {
        return workService.findOne(workId);
    }



    @CrossOrigin
    @RequestMapping(value = "/work", method = RequestMethod.POST)
    public String saveWork(@RequestBody Work work) {
        workService.save(work);
        return "redirect:/works";
    }

    @CrossOrigin
    @RequestMapping(value = "/workGroups", method = RequestMethod.GET)
    @Transactional
    public List<WorkGroupTitle> findWorkGroups() {
        return workGroupTitleService.findAll();
    }


}
