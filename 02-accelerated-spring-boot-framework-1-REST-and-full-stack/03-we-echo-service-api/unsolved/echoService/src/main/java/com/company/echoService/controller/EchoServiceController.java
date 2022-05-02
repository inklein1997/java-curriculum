package com.company.echoService.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EchoServiceController {

    @RequestMapping(value="/echo/{numberToEcho}", method= RequestMethod.GET)
    public int getNumber(@PathVariable int numberToEcho) {
        System.out.println("You are printing out " + numberToEcho);
        return numberToEcho;
    }
}
