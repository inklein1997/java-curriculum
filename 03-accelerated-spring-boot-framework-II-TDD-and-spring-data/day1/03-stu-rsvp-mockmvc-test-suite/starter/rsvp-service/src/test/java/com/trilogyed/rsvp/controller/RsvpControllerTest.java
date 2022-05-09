package com.trilogyed.rsvp.controller;

import com.trilogyed.rsvp.repository.RsvpRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(RsvpController.class)
public class RsvpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RsvpRepository repo;

    @Test
    public void shouldCreateNewRsvpOnPostRequest() throws Exception {
    }

    @Test
    public void shouldReturnRsvpById() throws Exception {
    }

    @Test
    public void shouldBStatusOkForNonExistentRsvpId() throws Exception {
    }

    @Test
    public void shouldReturnAllRsvps() throws Exception {
    }

    @Test
    public void shouldUpdateByIdAndReturn200StatusCode() throws Exception {
    }

    @Test
    public void shouldDeleteByIdAndReturn200StatusCode() throws Exception {
    }

}