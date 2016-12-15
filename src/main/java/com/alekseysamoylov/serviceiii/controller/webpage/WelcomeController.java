package com.alekseysamoylov.serviceiii.controller.webpage;

import com.alekseysamoylov.serviceiii.entity.work.WorkGroup;
import com.alekseysamoylov.serviceiii.service.WorkGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @RequestMapping(value = "/admin")
    public String goAdmin() {
        return "admin";
    }

    @RequestMapping(value = "/client")
    public String goClient() {
        return "test";
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


    @RequestMapping("/login")
    public String login() throws Exception {
        return "/auth/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }





}
