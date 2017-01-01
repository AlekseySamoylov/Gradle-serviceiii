package com.alekseysamoylov.serviceiii.controller.rest;

import com.alekseysamoylov.serviceiii.entity.security.User;
import com.alekseysamoylov.serviceiii.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Long login(@RequestBody User user) {
        return userService.login(user);
    }

}
