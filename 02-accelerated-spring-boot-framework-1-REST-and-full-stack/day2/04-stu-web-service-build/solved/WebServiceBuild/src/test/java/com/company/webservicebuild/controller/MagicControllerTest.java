package com.company.webservicebuild.controller;

import com.company.webservicebuild.model.Answer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MagicController.class)
public class MagicControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnRandomAnswer() throws Exception {

        // ARRANGE
        Answer inputAnswer = new Answer();
        inputAnswer.setQuestion("Will my test pass?");

        String inputJson = mapper.writeValueAsString(inputAnswer);

        // ACT
        mockMvc.perform(
                post("/magic")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isCreated())                         // ASSERT that we got 201 CREATED.
                .andExpect(jsonPath("$.answer").isNotEmpty())   // ASSERT that we got back a non-empty answer.
                .andExpect(jsonPath("$.id").isNotEmpty())       // ASSERT that we got back a non-empty id.

                // ASSERT that we got back a non-empty answer.
                .andExpect(jsonPath("$.question").value(inputAnswer.getQuestion()));
    }
}
