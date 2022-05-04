package com.webService.webServices.controllers;

import com.webService.webServices.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@RestController
public class QuoteController {

    private List<Quote> quoteList;

    private int correctInt;


    public QuoteController() {
        quoteList = new ArrayList<>();
        quoteList.add(new Quote("Matt", "There's so much information", 1));
        quoteList.add(new Quote("Hoa", "I dont know",2));
        quoteList.add(new Quote("Michael", "Y'all should watch Moon Knight",3));
        quoteList.add(new Quote("Matt", "There's so much information", 4));
        quoteList.add(new Quote("Hoa", "I dont know", 5));
        quoteList.add(new Quote("Michael", "Y'all should watch Moon Knight",6));
        quoteList.add(new Quote("Matt", "There's so much information", 7));
        quoteList.add(new Quote("Hoa", "I dont know", 8));
        quoteList.add(new Quote("Michael", "Y'all should watch Moon Knight", 9));
        quoteList.add(new Quote("Michael", "Y'all should watch Moon Knight", 10));
    }
//    quoteList.add( new Quote)


    public int correctInt() {
        return correctInt;
    }

    @RequestMapping(value="/quote", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Quote getQuotes() {

        // Random number generator
        Random rand = new Random();
        // this makes one from 0 to 9
        int randomInt = rand.nextInt(9);
        correctInt = randomInt;
        System.out.println(correctInt);

        return quoteList.get(correctInt);
    }

}
