package com.alekseysamoylov.serviceiii.controller;


import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Контроллер для обработки ошибок, прав доступа и отображения пользователю соответствующих сообщений
 */
@ControllerAdvice(basePackages = {"com.alekseysamoylov.serviceiii.controller"})
public class BaseController {

    private final Logger logger = Logger.getLogger(BaseController.class);

    @ResponseStatus(HttpStatus.NOT_FOUND)  // 404
    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Model model, Exception ex) throws Exception {
        logger.error("Request: " + req.getRequestURL() + " raised " + ex);
        logger.error(ex.getStackTrace());

        model.addAttribute("exception", ex);
        model.addAttribute("url", req.getRequestURL());

        return "error";
    }

    @RequestMapping(value = "/403")
    public String errorPage403() throws Exception {
        return "auth/403";
    }


}
