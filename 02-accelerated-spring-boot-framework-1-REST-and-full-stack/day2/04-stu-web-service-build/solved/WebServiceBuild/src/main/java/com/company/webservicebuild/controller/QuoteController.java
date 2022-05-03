package com.company.webservicebuild.controller;

import com.company.webservicebuild.model.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
public class QuoteController {

    private static Quote[] quotes = {
            new Quote(0, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(1, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(2, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(3, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(4, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(5, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(6, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(7, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(8, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana."),
            new Quote(9, "Groucho Marx", "Time flies like an arrow. Fruit flies like a banana.")
    };

    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Quote getQuote() {

        Random rand = new Random();

        return quotes[rand.nextInt(10)];
    }
}
