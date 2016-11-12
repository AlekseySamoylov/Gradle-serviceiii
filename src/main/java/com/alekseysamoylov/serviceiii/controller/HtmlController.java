package com.alekseysamoylov.serviceiii.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by alekseysamoylov on 11/12/16.
 */
@Controller
public class HtmlController {
    @RequestMapping(value = "/")
    public String goWelcome() {
        return "index";
    }

}
