package com.webService.webServices.controllers;

import com.webService.webServices.models.MathSolution;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class MathSolutionController {

    public MathSolution mathSolution(MathSolution operands, String operation) {

        int arithmetic;

        switch (operation) {
            case "add":
                arithmetic = operands.getOperand1() + operands.getOperand2();
                break;
            case "subtract":
                arithmetic = operands.getOperand1() - operands.getOperand2();
                break;
            case "multiply":
                arithmetic = operands.getOperand1() * operands.getOperand2();
                break;
            case "divide":
                arithmetic = operands.getOperand1() / operands.getOperand2();
                break;
            default:
                throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "please use an actual operation");

        }

        MathSolution mathSolution = new MathSolution(
                operands.getOperand1(),
                operands.getOperand2(),
                operation,
                arithmetic
        );
        return mathSolution;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution addInts(@Valid @RequestBody MathSolution operands) {
        return mathSolution(operands, "add");
    }

    @PostMapping("/subtract")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution subtractInts(@Valid @RequestBody MathSolution operands) {
        return mathSolution(operands, "subtract");
    }

    @PostMapping("/multiply")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution multiplyInts(@Valid @RequestBody MathSolution operands) {
        return mathSolution(operands, "multiply");
    }

    @PostMapping("/divide")
    @ResponseStatus(HttpStatus.CREATED)
    public MathSolution divideInts(@Valid @RequestBody MathSolution operands) {
        return mathSolution(operands, "divide");
    }
}
