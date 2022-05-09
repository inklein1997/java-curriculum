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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(IngredientController.class)
public class IngredientControllerTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    IngredientRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private Ingredient ingredient;
    private String ingredientJson;
    private List<Ingredient> allIngredients = new ArrayList<>();
    private String allIngredientsJson;

    @Before
    public void setup() throws Exception {
        ingredient = new Ingredient();
        ingredient.setName("Cheddar Cheese");
        ingredient.setDescription("Finely shredded cheddar cheese.");
        ingredient.setIngredientId(23);
        ingredient.setAmount("5 ounces");
        ingredient.setRecipeId(1);
        ingredientJson = mapper.writeValueAsString(ingredient);

        Ingredient ingredient1 = new Ingredient();
        ingredient1.setName("Ground Beef");
        ingredient1.setDescription("95% Lean");
        ingredient1.setIngredientId(8);
        ingredient1.setAmount("8 ounces");
        ingredient1.setRecipeId(1);

        allIngredients.add(ingredient);
        allIngredients.add(ingredient1);
        allIngredientsJson = mapper.writeValueAsString(allIngredients);
    }

    @Test
    public void shouldCreateNewIngredientOnPostRequest() throws Exception {
        Ingredient inputIngredient = new Ingredient();
        inputIngredient.setRecipeId(1);
        inputIngredient.setName("Cheddar Cheese");
        inputIngredient.setDescription("Finely shredded cheddar cheese.");
        inputIngredient.setAmount("5 ounces");

        String inputJson = mapper.writeValueAsString(inputIngredient);

        doReturn(ingredient).when(repo).save(inputIngredient);

        mockMvc.perform(
                post("/ingredients")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(ingredientJson));
    }

    @Test
    public void shouldReturnIngredientById() throws Exception {
        Optional<Ingredient> optIngredient = Optional.of(ingredient);
        doReturn(optIngredient).when(repo).findById(23);

        mockMvc.perform(
                get("/ingredients/23"))
                .andExpect(status().isOk())
                .andExpect((content().json(ingredientJson))
                );
    }

    @Test
    public void shouldReturnAllIngredientsByRecipeId() throws Exception {
        doReturn(allIngredients).when(repo).findAllIngredientsByRecipeId(1);

        mockMvc.perform(
                get("/ingredients/recipe/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(allIngredientsJson))
                );
    }

    @Test
    public void shouldUpdateIngredientAndReturnStatus200() throws Exception {
        mockMvc.perform(
                put("/ingredients")
                        .content(ingredientJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteByIdAndReturnStatus200() throws Exception {
        mockMvc.perform(delete("/ingredients/23")).andExpect(status().isOk());

    }

}