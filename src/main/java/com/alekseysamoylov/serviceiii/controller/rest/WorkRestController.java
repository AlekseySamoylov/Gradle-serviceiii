package com.alekseysamoylov.serviceiii.controller.rest;

import com.alekseysamoylov.serviceiii.entity.work.Work;
import com.alekseysamoylov.serviceiii.entity.work.WorkGroup;
import com.alekseysamoylov.serviceiii.model.WorkGroupTitle;
import com.alekseysamoylov.serviceiii.service.EnumDetailsService;
import com.alekseysamoylov.serviceiii.service.WorkGroupService;
import com.alekseysamoylov.serviceiii.service.WorkGroupTitleService;
import com.alekseysamoylov.serviceiii.service.WorkService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Aleksey Samoylov on 29.12.2015.
 *
 * Контроллер Rest
 */
@RestController
@CommonsLog
@RequestMapping(value = "/rest")
public class WorkRestController {

    private EnumDetailsService enumDetailsService;
    private WorkGroupService workGroupService;
    private WorkGroupTitleService workGroupTitleService;
    private WorkService workService;

    @Autowired
    public WorkRestController(EnumDetailsService enumDetailsService,
                              WorkGroupService workGroupService,
                              WorkGroupTitleService workGroupTitleService,
                              WorkService workService) {
        this.enumDetailsService = enumDetailsService;
        this.workGroupService = workGroupService;
        this.workGroupTitleService = workGroupTitleService;
        this.workService = workService;
    }

    @CrossOrigin
    @RequestMapping(value = "/enums")
    public Map<String, String> getEnumDetails() {
        return enumDetailsService.getEnumDetails();
    }

    @CrossOrigin
    @RequestMapping(value = "/works", method = RequestMethod.GET)
    public List<WorkGroup> findWorks() {
        return workGroupService.findAllFetchLazy();
    }

    @CrossOrigin
    @RequestMapping(value = "/worksByGroupId/{id}", method = RequestMethod.GET)
    public List<Work> findWorksByGroupId(@PathVariable Long id) {
        return workService.findByWorkGroupId(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/works/{id}", method = RequestMethod.GET)
    public Work findWork(@PathVariable Long id) {
        return workService.findOne(id);
    }


    @CrossOrigin
    @RequestMapping(value = "/works", method = RequestMethod.POST)
    public void saveWork(@RequestBody Work work) {
        workService.save(work);
    }

    @CrossOrigin
    @RequestMapping(value = "/works/{id}", method = RequestMethod.PUT)
    public void saveWork(@RequestBody Work work, @PathVariable Long id) {
        workService.update(work, id);
    }

    @CrossOrigin
    @RequestMapping(value = "/works/{id}", method = RequestMethod.DELETE)
    public void deleteWork(@PathVariable Long id) {
        workService.delete(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/workGroups", method = RequestMethod.GET)
    public List<WorkGroupTitle> findWorkGroups() {
        return workGroupTitleService.findAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/workGroups/{workGroupId}", method = RequestMethod.GET)
    public WorkGroup findOneWorkGroup(@PathVariable Long workGroupId) {
        return workGroupService.findOneFetchLazy(workGroupId);
    }


    @CrossOrigin
    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    public void saveString(@RequestBody Work work) {
        System.out.println("hello work " + work);
        System.out.println("hello id " + work.getWorkGroup().getId());
    }



}
