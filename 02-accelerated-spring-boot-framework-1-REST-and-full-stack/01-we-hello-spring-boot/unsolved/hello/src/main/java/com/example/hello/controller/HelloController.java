package com.example.hello.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping(value="/", method=RequestMethod.GET)
    String sayHello() {
        return "hello";
    }
}