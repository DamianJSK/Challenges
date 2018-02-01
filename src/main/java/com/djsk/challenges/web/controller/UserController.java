package com.djsk.challenges.web.controller;

import com.djsk.challenges.business.service.IUserService;
import com.djsk.challenges.persistence.dto.UserDto;
import com.djsk.challenges.persistence.entity.User;
import com.djsk.challenges.web.exception.EmailExistsException;
import com.djsk.challenges.web.exception.InvalidDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register_user")
    public User registerUser(@RequestBody @Valid UserDto userDto, BindingResult result){
        User user = null;
        if(!result.hasErrors()) {
            user = userService.createUserFromUserDto(userDto);
        }else if(result.hasErrors()){
            //This error should be configured to return correct message in body
            throw new InvalidDataException(result.getAllErrors().get(0).getDefaultMessage());
        }
        return user;
    }
}
