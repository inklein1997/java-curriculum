package com.webService.webServices.controllers;

import com.webService.webServices.models.MagicEightBall;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webService.webServices.models.Quote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MagicEightBallController.class)
public class MagicEightBallControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {}

    @Test
    public void shouldReturnRandomMagicEightBall() throws Exception {
        // Arrange
        mockMvc.perform(get("/magicEightBall"))
                .andDo(print())
                .andExpect(status().isOk())                              // ASSERT that we got 200 OK.
                .andExpect(jsonPath("$.question").isNotEmpty())         // ASSERT that we got back a non-empty question.
                .andExpect(jsonPath("$.id").isNotEmpty())           // ASSERT that we got back a non-empty id.
                .andExpect(jsonPath("$.answer").isNotEmpty());  // ASSERT that we got back a non-empty answer.
    }
}