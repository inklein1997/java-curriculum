package com.trilogyed.hellocircle.controller;

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
@WebMvcTest(HelloCircleController.class)
public class HelloCircleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnHello() throws Exception {
        // arrange and act
        mockMvc.perform(get("/hello"))
                .andDo(print())
                .andExpect(status().isOk())

        // assert
                .andExpect(content().string("Hello, Circle!"));
    }
}