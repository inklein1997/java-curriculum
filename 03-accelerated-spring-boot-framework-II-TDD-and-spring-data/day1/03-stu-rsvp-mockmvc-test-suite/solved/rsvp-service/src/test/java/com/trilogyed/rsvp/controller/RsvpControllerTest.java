package com.trilogyed.rsvp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.rsvp.model.Rsvp;
import com.trilogyed.rsvp.repository.RsvpRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RsvpController.class)
public class RsvpControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RsvpRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private Rsvp smithRsvp;
    private String smithJson;
    private List<Rsvp> allRsvps = new ArrayList<>();
    private String allRsvpsJson;

    @Before
    public void setup() throws Exception {
        smithRsvp = new Rsvp();
        smithRsvp.setId(9999);
        smithRsvp.setName("Sam Smith");
        smithRsvp.setTotalAttending(3);

        smithJson = mapper.writeValueAsString(smithRsvp);

        Rsvp rsvp = new Rsvp();
        rsvp.setId(1357);
        rsvp.setName("Julie Jones");
        rsvp.setTotalAttending(2);
        allRsvps.add(smithRsvp);
        allRsvps.add(rsvp);

        allRsvpsJson = mapper.writeValueAsString(allRsvps);

    }

    @Test
    public void shouldCreateNewRsvpOnPostRequest() throws Exception {
        Rsvp inputRsvp = new Rsvp();
        inputRsvp.setId(9999);
        inputRsvp.setName("Sam Smith");
        inputRsvp.setTotalAttending(3);
        String inputJson = mapper.writeValueAsString(inputRsvp);

        doReturn(smithRsvp).when(repo).save(inputRsvp);

        mockMvc.perform(
                post("/rsvps")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(smithJson));

    }

    @Test
    public void shouldReturnRsvpById() throws Exception {
        doReturn(Optional.of(smithRsvp)).when(repo).findById(9999);

        ResultActions result = mockMvc.perform(
                get("/rsvps/9999"))
                .andExpect(status().isOk())
                .andExpect((content().json(smithJson))
        );
    }

    @Test
    public void shouldBStatusOkForNonExistentRsvpId() throws Exception {
        doReturn(Optional.empty()).when(repo).findById(1234);

        mockMvc.perform(
                get("/rsvps/1234"))
                .andExpect(status().isOk()
        );

    }

    @Test
    public void shouldReturnAllRsvps() throws Exception {
        doReturn(allRsvps).when(repo).findAll();

        mockMvc.perform(
                get("/rsvps"))
                .andExpect(status().isOk())
                .andExpect(content().json(allRsvpsJson)
        );
    }

    @Test
    public void shouldUpdateByIdAndReturn200StatusCode() throws Exception {
        mockMvc.perform(
                put("/rsvps")
                        .content(smithJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteByIdAndReturn200StatusCode() throws Exception {
        mockMvc.perform(delete("/rsvps/2")).andExpect(status().isOk());
    }

}