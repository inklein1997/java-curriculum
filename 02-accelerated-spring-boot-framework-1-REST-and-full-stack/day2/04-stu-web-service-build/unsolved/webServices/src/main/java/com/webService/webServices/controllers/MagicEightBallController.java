package com.webService.webServices.controllers;

import com.webService.webServices.models.MagicEightBall;
import com.webService.webServices.models.Word;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class MagicEightBallController {
    private List<MagicEightBall> magicEightBallAnswers;

    public MagicEightBallController() {
        magicEightBallAnswers= new ArrayList<>();
        magicEightBallAnswers.add(new MagicEightBall("1?", "1", 1));
        magicEightBallAnswers.add(new MagicEightBall("2?", "2",2));
        magicEightBallAnswers.add(new MagicEightBall("C?", "3",3));
        magicEightBallAnswers.add(new MagicEightBall("D?", "4", 4));
        magicEightBallAnswers.add(new MagicEightBall("E?", "5", 5));
        magicEightBallAnswers.add(new MagicEightBall("F?", "6",6));
        magicEightBallAnswers.add(new MagicEightBall("G?", "7", 7));
        magicEightBallAnswers.add(new MagicEightBall("H?", "8", 8));
        magicEightBallAnswers.add(new MagicEightBall("I?", "9", 9));
        magicEightBallAnswers.add(new MagicEightBall("J?", "10", 10));
    }

    @RequestMapping(value="/magicEightBall", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public MagicEightBall getAnswer() {

        // Random number generator
        Random rand = new Random();
        // this makes one from 0 to 9
        int randomInt = rand.nextInt(10);
        int correctInt = randomInt;
        System.out.println(correctInt);

        return magicEightBallAnswers.get(correctInt);
    }

}
