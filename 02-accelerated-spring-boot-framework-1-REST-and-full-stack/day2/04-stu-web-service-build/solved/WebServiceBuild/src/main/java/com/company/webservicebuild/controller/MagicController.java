package com.company.webservicebuild.controller;

import com.company.webservicebuild.model.Answer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class MagicController {

    private static int idCounter = 0;

    private static String[] answers = {
            "It is certain.",
            "It is decidedly so.",
            "Reply hazy, try again.",
            "Ask again later.",
            "Don't count on it.",
            "Outlook not so good."
    };

    @RequestMapping(value = "/magic", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Answer getAnswer(@RequestBody @Valid Answer question) {

        Random rand = new Random();

        question.setId(idCounter++);
        question.setAnswer(answers[rand.nextInt(6)]);

        return question;
    }
}
