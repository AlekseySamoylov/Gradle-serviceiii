package com.alekseysamoylov.serviceiii.controller.webpage;

import com.alekseysamoylov.serviceiii.entity.WorkGroup;
import com.alekseysamoylov.serviceiii.service.WorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by alekseysamoylov on 11/12/16.
 * Контроллер legacy
 */
@Controller
public class WelcomeController {

    private WorkGroupService workGroupService;

    @Autowired
    public WelcomeController(WorkGroupService workGroupService) {
        this.workGroupService = workGroupService;
    }

    @RequestMapping(value = "/")
    public String goWelcome() {
        return "index";
    }

    @RequestMapping(value = "/fileUpload")
    public String goFileUpload() {
        return "fileUpload";
    }


    @CrossOrigin
    @RequestMapping(value = "/prices")
    @ResponseBody
    public List<WorkGroup> getPrices() {
        return workGroupService.findAllFetchLazy();
    }


}
