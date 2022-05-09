package com.example.recipe.controller;

import com.example.recipe.model.Recipe;
import com.example.recipe.repository.RecipeRepository;
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
@WebMvcTest(RecipeController.class)
public class RecipeControllerTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    RecipeRepository repo;

    ObjectMapper mapper = new ObjectMapper();

    private Recipe recipe;
    private String recipeJson;
    private List<Recipe> allRecipes = new ArrayList<>();
    private String allRecipesJson;

    @Before
    public void setup() throws Exception {
        recipe = new Recipe();
        recipe.setDescription("Melt In Your Mouth Ribs!");
        recipe.setTitle("Spare Ribs");
        recipe.setRecipeId(1);
        recipe.setCookTime("7 hours");
        recipe.setServings(6);
        recipe.setPrepTime("45 minutes");
        recipe.setCategory("BBQ");

        recipeJson = mapper.writeValueAsString(recipe);

        Recipe recipe1 = new Recipe();
        recipe1.setDescription("The best Texas brisket ever!");
        recipe1.setTitle("Beef Brisket");
        recipe1.setRecipeId(2);
        recipe1.setCookTime("8 hours");
        recipe1.setServings(8);
        recipe1.setPrepTime("16 hours");
        recipe1.setCategory("BBQ");

        allRecipes.add(recipe);
        allRecipes.add(recipe1);

        allRecipesJson = mapper.writeValueAsString(allRecipes);
    }

    @Test
    public void shouldCreateNewRecipeOnPost() throws Exception {
        Recipe input = new Recipe();
        input.setDescription("Melt In Your Mouth Ribs!");
        input.setTitle("Spare Ribs");
        input.setCookTime("7 hours");
        input.setServings(6);
        input.setPrepTime("45 minutes");
        input.setCategory("BBQ");

        String inputJson = mapper.writeValueAsString(input);

        doReturn(recipe).when(repo).save(input);

        mockMvc.perform(
                post("/recipes")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(recipeJson));
    }

    @Test
    public void shouldReturnRecipeById() throws Exception {
        Optional<Recipe> optRecipe = Optional.of(recipe);
        doReturn(optRecipe).when(repo).findById(1);

        mockMvc.perform(
                get("/recipes/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(recipeJson))
                );
    }

    @Test
    public void shouldReturnAllRecipes() throws Exception {
        doReturn(allRecipes).when(repo).findAll();

        mockMvc.perform(
                get("/recipes"))
                .andExpect(status().isOk())
                .andExpect(content().json(allRecipesJson)
                );
    }

    @Test
    public void shouldReturnAllRecipesByCategory() throws Exception {
        doReturn(allRecipes).when(repo).findAllRecipesByCategory("BBQ");

        mockMvc.perform(
                get("/recipes/category/BBQ"))
                .andExpect(status().isOk())
                .andExpect(content().json(allRecipesJson)
                );
    }

    @Test
    public void shouldUpdateRecipeAndReturnStatus200() throws Exception {
        mockMvc.perform(
                put("/recipes")
                        .content(recipeJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteRecipeAndReturnStatus200() throws Exception {
        mockMvc.perform(delete("/recipes/1")).andExpect(status().isOk());
    }
}