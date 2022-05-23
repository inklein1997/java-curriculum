package com.company.michaelsapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MichaelsAppController {
    @Value("${my.welcome.message}")
    private String officialGreeting;

    @GetMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public String sayhellowFromTheCloud() {
        return officialGreeting;
    }
}
