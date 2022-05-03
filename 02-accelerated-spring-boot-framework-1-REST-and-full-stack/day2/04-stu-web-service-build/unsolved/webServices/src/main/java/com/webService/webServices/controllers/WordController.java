package com.webService.webServices.controllers;

import com.webService.webServices.models.Quote;
import com.webService.webServices.models.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@RestController
public class WordController {
    private List<Word> wordAndDefList;

    public WordController() {
        wordAndDefList= new ArrayList<>();
        wordAndDefList.add(new Word("A", "1", 1));
        wordAndDefList.add(new Word("B", "2",2));
        wordAndDefList.add(new Word("C", "3",3));
        wordAndDefList.add(new Word("D", "4", 4));
        wordAndDefList.add(new Word("E", "5", 5));
        wordAndDefList.add(new Word("F", "6",6));
        wordAndDefList.add(new Word("G", "7", 7));
        wordAndDefList.add(new Word("H", "8", 8));
        wordAndDefList.add(new Word("I", "9", 9));
        wordAndDefList.add(new Word("J", "10", 10));
    }

    @RequestMapping(value="/word", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Word getWord() {

        // Random number generator
        Random rand = new Random();
        // this makes one from 0 to 9
        int randomInt = rand.nextInt(9);
        int correctInt = randomInt;
        System.out.println(correctInt);

        return wordAndDefList.get(correctInt);
    }

}
