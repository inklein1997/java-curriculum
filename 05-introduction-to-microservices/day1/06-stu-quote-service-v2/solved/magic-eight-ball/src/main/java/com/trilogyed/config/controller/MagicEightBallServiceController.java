package com.trilogyed.config.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RefreshScope
public class MagicEightBallServiceController {
    String[] answers = {
            "No",
            "Yes",
            "Looking cloudy",
            "Not sure",
            "Absolutely!",
            "Ask again",
            "Ummm",
            "Not a chance"
    };

    Random rndNumGenerator = new Random();

    @GetMapping(value="/answer")
    public String getAnswer() {
        return answers[rndNumGenerator.nextInt(8)];
    }
}
