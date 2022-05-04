package com.company.EchoRangeService.controller;

import com.company.EchoRangeService.exception.DanHatesFivesException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoRangeServiceController {
    @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public int echo(@PathVariable int input) {
        if (input < 1 || input > 10) {
            throw new IllegalArgumentException("Input must be between 1 and 10");
        } else if (input == 5) {
            throw new DanHatesFivesException("Please do not send me a 5");
        } else if (input == 9) {
            throw new ArrayIndexOutOfBoundsException("Weird.  9 is no good either...");
        } else {
            return input;
        }
    }
}
