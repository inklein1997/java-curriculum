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

import java.util.HashMap;
import java.util.Map;

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
    public void shouldRespondWith422ErrorIfOperandsAreMissingWhilePerformingAdd() throws Exception {
//         ARRANGE
        Map<String, Integer> inputObject = new HashMap<>();
        inputObject.put("operand1", 1);

        String inputJSON = mapper.writeValueAsString(inputObject);
        // ACT
        mockMvc.perform(post("/add")
                .content(inputJSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldRespondWith422ErrorIfOperandsAreMissingWhilePerformingSubtract() throws Exception {
//         ARRANGE
        Map<String, Integer> inputObject = new HashMap<>();
        inputObject.put("operand1", 1);

        String inputJSON = mapper.writeValueAsString(inputObject);
        // ACT
        mockMvc.perform(post("/subtract")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldRespondWith422ErrorIfOperandsAreMissingWhilePerformingMultiply() throws Exception {
//         ARRANGE
        Map<String, Integer> inputObject = new HashMap<>();
        inputObject.put("operand1", 1);

        String inputJSON = mapper.writeValueAsString(inputObject);
        // ACT
        mockMvc.perform(post("/multiply")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldRespondWith422ErrorIfOperandsAreMissingWhilePerformingDivide() throws Exception {
//         ARRANGE
        Map<String, Integer> inputObject = new HashMap<>();
        inputObject.put("operand1", 1);

        String inputJSON = mapper.writeValueAsString(inputObject);
        // ACT
        mockMvc.perform(post("/divide")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void shouldRespondWith422ErrorIfOperandsAreNotNumbersWhenAdding() throws Exception {

        Map<String, String> randomObject = new HashMap<>();
        randomObject.put("operand1", "test");
        randomObject.put("operand2", "false");

        String inputJSON = mapper.writeValueAsString(randomObject);

        mockMvc.perform(post("/add")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, Boolean> randomObject1 = new HashMap<>();
        randomObject1.put("operand1", false);
        randomObject1.put("operand2", false);

        String inputJSON1 = mapper.writeValueAsString(randomObject1);

        mockMvc.perform(post("/add")
                        .content(inputJSON1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldRespondWith422ErrorIfOperandsAreNotNumbersWhenSubtracting() throws Exception {

        Map<String, String> randomObject = new HashMap<>();
        randomObject.put("operand1", "test");
        randomObject.put("operand2", "false");

        String inputJSON = mapper.writeValueAsString(randomObject);

        mockMvc.perform(post("/subtract")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, Boolean> randomObject1 = new HashMap<>();
        randomObject1.put("operand1", false);
        randomObject1.put("operand2", false);

        String inputJSON1 = mapper.writeValueAsString(randomObject1);

        mockMvc.perform(post("/subtract")
                        .content(inputJSON1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldRespondWith422ErrorIfOperandsAreNotNumbersWhenMultiplying() throws Exception {

        Map<String, String> randomObject = new HashMap<>();
        randomObject.put("operand1", "test");
        randomObject.put("operand2", "false");

        String inputJSON = mapper.writeValueAsString(randomObject);

        mockMvc.perform(post("/multiply")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, Boolean> randomObject1 = new HashMap<>();
        randomObject1.put("operand1", false);
        randomObject1.put("operand2", false);

        String inputJSON1 = mapper.writeValueAsString(randomObject1);

        mockMvc.perform(post("/multiply")
                        .content(inputJSON1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }
    @Test
    public void shouldRespondWith422ErrorIfOperandsAreNotNumbersWhenDividing() throws Exception {

        Map<String, String> randomObject = new HashMap<>();
        randomObject.put("operand1", "test");
        randomObject.put("operand2", "false");

        String inputJSON = mapper.writeValueAsString(randomObject);

        mockMvc.perform(post("/divide")
                        .content(inputJSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

        Map<String, Boolean> randomObject1 = new HashMap<>();
        randomObject1.put("operand1", false);
        randomObject1.put("operand2", false);

        String inputJSON1 = mapper.writeValueAsString(randomObject1);

        mockMvc.perform(post("/divide")
                        .content(inputJSON1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }


    @Test
    public void shouldRespondWith422ErrorIfOperand2IsZero() throws Exception {
        MathSolution inputDivideWith0 = new MathSolution();
        inputDivideWith0.setOperand1(1);
        inputDivideWith0.setOperand2(0);

        String inputJson = mapper.writeValueAsString(inputDivideWith0);

        mockMvc.perform(post("/divide")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());

    }
}