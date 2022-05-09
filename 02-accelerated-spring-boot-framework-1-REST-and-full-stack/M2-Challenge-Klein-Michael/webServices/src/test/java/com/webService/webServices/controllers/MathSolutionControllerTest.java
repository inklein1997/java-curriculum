package com.webService.webServices.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.webService.webServices.models.MathSolution;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MathSolutionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    String inputJSON;
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() throws Exception {
        MathSolution inputMathSolution = new MathSolution(2,2);
        inputJSON = mapper.writeValueAsString(inputMathSolution);
    }


    @Test
    public void shouldAddOperandsInRequestBodyAndReturnMathOperationWithStatus200() throws Exception {
        // ARRANGE
        MathSolution outputMathSolution = new MathSolution(2,2,"add", 4);
        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        // ACT
        mockMvc.perform(post("/add")
                .content(inputJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                // ASSERT
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldSubtractOperandsInRequestBodyAndReturnMathOperationWithStatus200() throws Exception {
        // ARRANGE
        MathSolution outputMathSolution = new MathSolution(2,2,"subtract", 0);
        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        // ACT
        mockMvc.perform(post("/subtract")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                // ASSERT
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldMultiplyOperandsInRequestBodyAndReturnMathOperationWithStatus200() throws Exception {
        // ARRANGE
        MathSolution outputMathSolution = new MathSolution(2,2,"multiply", 4);
        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        // ACT
        mockMvc.perform(post("/multiply")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                // ASSERT
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldDivideOperandsInRequestBodyAndReturnMathOperationWithStatus200() throws Exception {
        // ARRANGE
        MathSolution outputMathSolution = new MathSolution(2,2,"divide", 1);
        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        // ACT
        mockMvc.perform(post("/divide")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                // ASSERT
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldRespondWith422ErrorIfOperandsAreMissingOrAreNotNumber() throws Exception {
        // ARRANGE
        MathSolution inputMissingNumber = new MathSolution();
        inputMissingNumber.setOperand1(1);

        String inputJSON = mapper.writeValueAsString(inputMissingNumber);
        // ACT
        mockMvc.perform(post("/add")
                .content(inputJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
}