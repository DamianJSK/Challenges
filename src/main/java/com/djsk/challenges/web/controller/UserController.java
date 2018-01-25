package com.djsk.challenges.web.controller;

import com.djsk.challenges.business.service.IUserService;
import com.djsk.challenges.persistence.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @PostMapping
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @GetMapping("/{idi}")
    public User findOne(@PathVariable String idi){
        return userService.findOne(idi);
    }

    @GetMapping()
    public List<User> findAll(){
        return userService.findAll();
    }

    @PutMapping()
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @DeleteMapping("/{idi}")
    public void delete(@PathVariable String idi){
        userService.delete(userService.findOne(idi));
    }
}
