package com.example.recipe.controller;

import com.example.recipe.model.PrepStep;
import com.example.recipe.repository.PrepStepRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PrepStepController.class)
public class PrepStepControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    PrepStepRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private PrepStep prepStep;
    private String prepStepJson;
    private List<PrepStep> allPrepSteps = new ArrayList<>();
    private String allPrepStepsJson;

    @Before
    public void setup() throws Exception {
        prepStep = new PrepStep();
        prepStep.setPrepStepId(44);
        prepStep.setPrepStepText("Saute onions for 5 minutes.");
        prepStep.setStepNumber(4);
        prepStep.setRecipeId(1);

        prepStepJson = mapper.writeValueAsString(prepStep);

        PrepStep prepStep1 = new PrepStep();
        prepStep1.setPrepStepId(78);
        prepStep1.setPrepStepText("Chop onions.");
        prepStep1.setStepNumber(3);
        prepStep1.setRecipeId(1);

        allPrepSteps.add(prepStep);
        allPrepSteps.add(prepStep1);

        allPrepStepsJson = mapper.writeValueAsString(allPrepSteps);
    }

    @Test
    public void shouldCreateNewPrepStepOnPost() throws Exception {
        PrepStep inputPrepStep = new PrepStep();
        inputPrepStep.setPrepStepText("Saute onions for 5 minutes.");
        inputPrepStep.setStepNumber(4);
        inputPrepStep.setRecipeId(1);

        String inputPrepStepJson = mapper.writeValueAsString(inputPrepStep);

        doReturn(prepStep).when(repo).save(inputPrepStep);

        mockMvc.perform(
                post("/prepsteps")
                        .content(inputPrepStepJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(prepStepJson));
    }

    @Test
    public void shouldReturnPrepStepById() throws Exception {
        Optional<PrepStep> optPrepStep = Optional.of(prepStep);
        doReturn(optPrepStep).when(repo).findById(44);

        mockMvc.perform(
                get("/prepsteps/44"))
                .andExpect(status().isOk())
                .andExpect((content().json(prepStepJson))
                );
    }

    @Test
    public void shouldReturnAllPrepStepsForRecipeId() throws Exception {
        doReturn(allPrepSteps).when(repo).findAllPrepStepsByRecipeId(1);

        mockMvc.perform(
                get("/prepsteps/recipe/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(allPrepStepsJson))
                );
    }

    @Test
    public void shouldUpdatePrepStepAndReturnStatus200() throws Exception {
        mockMvc.perform(
                put("/prepsteps")
                        .content(prepStepJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeletePrepStepAndReturnStatus200() throws Exception {
        mockMvc.perform(delete("/prepsteps/23")).andExpect(status().isOk());

    }


}