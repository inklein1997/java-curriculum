package com.trilogyed.config.controller;

import com.trilogyed.config.util.feign.RandomGreetingClient;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest()
public class HelloCloudServiceControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private RandomGreetingClient client;

    @Before
    public void setUp() {
        when(client.getQuote()).thenReturn("NEVERMORE!!!");
    }

    @Test
    public void shouldReturn200WhenRequestingQuote throws Exception {
        String expectedResult = "Heres your quote: NEERMORE!!!";
        mockMvc.perform(get("/quote"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(expectedResult));
    }
}