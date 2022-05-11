package com.example.recipe.controller;

import com.example.recipe.model.Ingredient;
import com.example.recipe.repository.IngredientRepository;
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

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(IngredientController.class)
public class IngredientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IngredientRepository repo;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
        Ingredient mockInput = new Ingredient();
        mockInput.setIngredientId(1);
        mockInput.setAmount("1 oz");
        mockInput.setName("SnozzBerry");
        mockInput.setDescription("Made of SnozzBerry");
        mockInput.setRecipeId(1);

        Ingredient mockOutput = new Ingredient();
        mockOutput.setIngredientId(1);
        mockOutput.setAmount("1 oz");
        mockOutput.setName("SnozzBerry");
        mockOutput.setDescription("Made of SnozzBerry");
        mockOutput.setRecipeId(1);

        List<Ingredient> ingredientsList = new ArrayList();
        ingredientsList.add(mockOutput);

        doReturn(mockOutput).when(repo).save(mockInput);
        doReturn(Optional.of(mockOutput)).when(repo).findById(1);
        doReturn(ingredientsList).when(repo).findAllIngredientsByRecipeId(1);
    }

    @Test
    public void shouldCreateNewIngredientOnPostRequest() throws Exception {
        Ingredient inputIngredient = new Ingredient();
        inputIngredient.setIngredientId(1);
        inputIngredient.setAmount("1 oz");
        inputIngredient.setName("SnozzBerry");
        inputIngredient.setDescription("Made of SnozzBerry");
        inputIngredient.setRecipeId(1);

        String jsonInput = mapper.writeValueAsString(inputIngredient);

        Ingredient outputIngredient = new Ingredient();
        outputIngredient.setIngredientId(1);
        outputIngredient.setAmount("1 oz");
        outputIngredient.setName("SnozzBerry");
        outputIngredient.setDescription("Made of SnozzBerry");
        outputIngredient.setRecipeId(1);

        String jsonOutput = mapper.writeValueAsString(outputIngredient);

        mockMvc.perform(post("/ingredients")
                .content(jsonInput)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(jsonOutput));
    }

    @Test
    public void shouldReturnIngredientById() throws Exception {
        Ingredient outputIngredient = new Ingredient();
        outputIngredient.setIngredientId(1);
        outputIngredient.setAmount("1 oz");
        outputIngredient.setName("SnozzBerry");
        outputIngredient.setDescription("Made of SnozzBerry");
        outputIngredient.setRecipeId(1);

        String jsonOutput = mapper.writeValueAsString(outputIngredient);

        mockMvc.perform(get("/ingredients/1"))
                .andDo(print())
                .andExpect(content().json(jsonOutput))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllIngredientsByRecipeId() throws Exception {
        Ingredient outputIngredient = new Ingredient();
        outputIngredient.setIngredientId(1);
        outputIngredient.setAmount("1 oz");
        outputIngredient.setName("SnozzBerry");
        outputIngredient.setDescription("Made of SnozzBerry");
        outputIngredient.setRecipeId(1);

        List<Ingredient> ingredientsList = new ArrayList();
        ingredientsList.add(outputIngredient);

        String outputJson = mapper.writeValueAsString(ingredientsList);

        mockMvc.perform(get("/ingredients/recipe/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldUpdateByIdAndReturn200StatusCode() throws Exception {
        Ingredient inputRsvp = new Ingredient();
        inputRsvp.setIngredientId(1);
        inputRsvp.setAmount("1 oz");
        inputRsvp.setName("SnozzBerry");
        inputRsvp.setDescription("Made of SnozzBerry");
        inputRsvp.setRecipeId(1);

        String inputJson = mapper.writeValueAsString(inputRsvp);

        mockMvc.perform(put("/ingredients")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteByIdAndReturn200StatusCode() throws Exception {
        mockMvc.perform(delete("/ingredients/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

}