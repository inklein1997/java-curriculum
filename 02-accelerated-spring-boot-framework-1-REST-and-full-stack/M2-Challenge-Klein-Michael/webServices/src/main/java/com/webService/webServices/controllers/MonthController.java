package com.webService.webServices.controllers;

import com.webService.webServices.models.Month;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Random;

@RestController
public class MonthController {

    public Month monthSwitchCase(int monthNumber) {

        Month monthObject = new Month(monthNumber, "");

        switch (monthNumber) {
            case 1 :
                monthObject.setName("January");
                return monthObject;
            case 2 :
                monthObject.setName("February");
                return monthObject;
            case 3 :
                monthObject.setName("March");
                return monthObject;
            case 4 :
                monthObject.setName("April");
                return monthObject;
            case 5 :
                monthObject.setName("May");
                return monthObject;
            case 6 :
                monthObject.setName("June");
                return monthObject;
            case 7 :
                monthObject.setName("July");
                return monthObject;
            case 8 :
                monthObject.setName("August");
                return monthObject;
            case 9 :
                monthObject.setName("September");
                return monthObject;
            case 10 :
                monthObject.setName("October");
                return monthObject;
            case 11 :
                monthObject.setName("November");
                return monthObject;
            case 12 :
                monthObject.setName("December");
                return monthObject;
            default:
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "invalid month");
        }
    }

    @GetMapping("/month/{monthNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Month getMonthByNumber(@PathVariable int monthNumber) {
        return monthSwitchCase(monthNumber);
    }

    @GetMapping("/randomMonth")
    @ResponseStatus(HttpStatus.OK)
    public Month getRandomMonth() {
        Random rand = new Random();
        int randomInt = rand.nextInt(12) + 1;
        return monthSwitchCase(randomInt);
    }

}
