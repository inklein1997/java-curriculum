package com.trilogyed.hello.heroku.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHerokuController {

    @GetMapping(value = "/hello")
    public String helloHeroku(){
        return "Hello, Heroku!";
    }
}
