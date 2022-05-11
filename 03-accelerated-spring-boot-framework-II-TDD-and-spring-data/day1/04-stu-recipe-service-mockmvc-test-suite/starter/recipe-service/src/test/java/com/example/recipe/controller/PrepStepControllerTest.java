package com.example.recipe.controller;

import com.example.recipe.model.Ingredient;
import com.example.recipe.repository.IngredientRepository;
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


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(IngredientController.class)
public class PrepStepControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PrepStepRepository repo;

    ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {
//        doReturn(recipe).when(repo).save(input);
//        when(repo.save(input)).thenReturn(recipe);
        // THESE DO THE SAME THING!

    }
}