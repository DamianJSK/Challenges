package com.djsk.challenges.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/foo")
public class FooController {

    @GetMapping
    public String getFoo(){
        return "Foo endpoint, class: " + this.getClass().toString();
    }
}
