package com.company.magiceightballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RefreshScope
public class MagicEightBallController {

    List<String> answers = Arrays.asList(
            "No",
            "Yes",
            "Looking cloudy",
            "Not sure",
            "Absolutely!",
            "Ask again",
            "Ummm",
            "Not a chance"
    );

    @GetMapping("/answer")
    public String getAnswer() {
        return answers.get((int) Math.floor(Math.random() * answers.size()));
    }
}
