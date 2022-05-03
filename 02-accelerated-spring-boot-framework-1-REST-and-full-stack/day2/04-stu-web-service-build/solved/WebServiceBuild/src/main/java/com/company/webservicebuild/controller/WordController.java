package com.company.webservicebuild.controller;

import com.company.webservicebuild.model.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WordController {

    private static Word[] words = {
            new Word(0, "obstreperous", "adj. noisy and difficult to control"),
            new Word(1, "obstreperous", "adj. noisy and difficult to control"),
            new Word(2, "obstreperous", "adj. noisy and difficult to control"),
            new Word(3, "obstreperous", "adj. noisy and difficult to control"),
            new Word(4, "obstreperous", "adj. noisy and difficult to control"),
            new Word(5, "obstreperous", "adj. noisy and difficult to control"),
            new Word(6, "obstreperous", "adj. noisy and difficult to control"),
            new Word(7, "obstreperous", "adj. noisy and difficult to control"),
            new Word(8, "obstreperous", "adj. noisy and difficult to control"),
            new Word(9, "obstreperous", "adj. noisy and difficult to control"),
    };

    @RequestMapping(value = "/word", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Word getWord() {

        Random rand = new Random();

        return words[rand.nextInt(10)];
    }
}
