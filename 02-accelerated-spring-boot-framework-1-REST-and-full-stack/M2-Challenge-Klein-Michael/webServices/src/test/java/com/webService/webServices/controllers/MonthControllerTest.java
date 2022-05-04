package com.webService.webServices.controllers;

import com.webService.webServices.models.Month;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MathSolutionController.class)
public class MonthControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    // testing Get request month converter
    @Test
    public void shouldGetMonthUsingPathVariable() throws Exception {
        // ARRANGE
        Month outputMonth = new Month();
        outputMonth.setNumber(2);
        outputMonth.setName("February");

        // Convert to JSON using mapper
        String outputJSON = mapper.writeValueAsString(outputMonth);

        mockMvc.perform(get("/month/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJSON));
    }

    @Test
    public void shouldGetRandomMonth() throws Exception {
        // ARRANGE
        Month outputMonth = new Month(1, "January");

    }
}