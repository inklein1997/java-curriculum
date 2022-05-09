package com.company.MonthConverter.controllers;

import com.company.MonthConverter.controllers.MonthConverterController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Month;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MonthConverterController.class)
public class MonthConverterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnMonthWithNumberBetween1and12() throws Exception {
        mockMvc.perform(get("/month/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("Feb"));
    }

    @Test
    public void shouldReturnWithAStatusOf403ForbiddenStatusWithANumNotBetween1And12() throws Exception{
        mockMvc.perform(get("/month/100"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}