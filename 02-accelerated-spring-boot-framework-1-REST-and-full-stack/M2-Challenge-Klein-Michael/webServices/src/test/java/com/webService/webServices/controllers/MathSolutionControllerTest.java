package com.webService.webServices.controllers;

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

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldAddOperandsInRequestBody() throws Exception {
        // ARRANGE / TEST SETUP
        MathSolution outputMathSolution = new MathSolution(2,2,"add", 4);
        MathSolution inputMathSolution = new MathSolution(2,2,"add", 4);

        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        String inputJSON = mapper.writeValueAsString(inputMathSolution);

        // ACT
        mockMvc.perform(post("/add")
                .content(inputJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldSubtractOperandsInRequestBody() throws Exception {
        // ARRANGE / TEST SETUP
        MathSolution outputMathSolution = new MathSolution(2,2,"subtract", 0);
        MathSolution inputMathSolution = new MathSolution(2,2,"subtract", 0);

        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        String inputJSON = mapper.writeValueAsString(inputMathSolution);

        // ACT
        mockMvc.perform(post("/subtract")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldMultiplyOperandsInRequestBody() throws Exception {
        // ARRANGE / TEST SETUP
        MathSolution outputMathSolution = new MathSolution(2,2,"multiply", 4);
        MathSolution inputMathSolution = new MathSolution(2,2,"multiply", 4);

        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        String inputJSON = mapper.writeValueAsString(inputMathSolution);

        // ACT
        mockMvc.perform(post("/multiply")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldDivideOperandsInRequestBody() throws Exception {
        // ARRANGE / TEST SETUP
        MathSolution outputMathSolution = new MathSolution(2,2,"divide", 1);
        MathSolution inputMathSolution = new MathSolution(2,2,"divide", 1);

        String outputJSON = mapper.writeValueAsString(outputMathSolution);
        String inputJSON = mapper.writeValueAsString(inputMathSolution);

        // ACT
        mockMvc.perform(post("/divide")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJSON));
    }
}