package com.example.recipe.controller;

import com.example.recipe.model.Rating;
import com.example.recipe.repository.RatingRepository;
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
@WebMvcTest(RatingController.class)
public class RatingControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    RatingRepository repo;

    private ObjectMapper mapper = new ObjectMapper();

    private Rating rating;
    private String ratingJson;
    private List<Rating> allRatings = new ArrayList<>();
    private String allRatingsJson;

    @Before
    public void setup() throws Exception {
        rating = new Rating();
        rating.setRatingId(99);
        rating.setRecipeId(1);
        rating.setRecommended(true);
        rating.setNumStars(5);
        rating.setRatingText("This recipe is amazing!!!");

        ratingJson = mapper.writeValueAsString(rating);

        Rating rating1 = new Rating();
        rating1.setRatingId(101);
        rating1.setRecipeId(1);
        rating1.setRecommended(true);
        rating1.setNumStars(4);
        rating1.setRatingText("Solid recipe - I'd try it again.");

        allRatings.add(rating);
        allRatings.add(rating1);

        allRatingsJson = mapper.writeValueAsString(allRatings);
    }

    @Test
    public void shouldCreateRatingOnPost() throws Exception {
        Rating inputRating = new Rating();
        inputRating.setRecipeId(1);
        inputRating.setRecommended(true);
        inputRating.setNumStars(5);
        inputRating.setRatingText("This recipe is amazing!!!");

        String inputRatingJson = mapper.writeValueAsString(inputRating);

        doReturn(rating).when(repo).save(inputRating);

        mockMvc.perform(
                post("/ratings")
                        .content(inputRatingJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(ratingJson));
    }

    @Test
    public void shouldReturnRatingById() throws Exception {
        Optional<Rating> optRating = Optional.of(rating);
        doReturn(optRating).when(repo).findById(99);

        mockMvc.perform(
                get("/ratings/99"))
                .andExpect(status().isOk())
                .andExpect((content().json(ratingJson))
                );
    }

    @Test
    public void shouldReturnAllRatingsForRecipeId() throws Exception {
        doReturn(allRatings).when(repo).findAllRatingsByRecipeId(1);

        mockMvc.perform(
                get("/ratings/recipe/1"))
                .andExpect(status().isOk())
                .andExpect((content().json(allRatingsJson))
                );
    }

    @Test
    public void shouldUpdateRatingAndReturnStatus200() throws Exception {
        mockMvc.perform(
                put("/ratings")
                        .content(ratingJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteRatingAndReturnStatus200() throws Exception {
        mockMvc.perform(delete("/ratings/99")).andExpect(status().isOk());
    }
}