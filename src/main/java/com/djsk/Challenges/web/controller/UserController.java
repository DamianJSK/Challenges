package com.djsk.Challenges.web.controller;

import com.djsk.Challenges.business.service.IUserService;
import com.djsk.Challenges.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public void create(@RequestBody User user){
        userService.create(user);
    }

}
