package com.alekseysamoylov.serviceiii.controller.rest;

import com.alekseysamoylov.serviceiii.entity.security.User;
import com.alekseysamoylov.serviceiii.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Конроллер для работы с сущностью {@link User}
 */
@RestController
@RequestMapping(value = "/rest")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public Long addUser(User user) {
        return userService.save(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Long login(User user) {
        return userService.login(user);
    }

}
