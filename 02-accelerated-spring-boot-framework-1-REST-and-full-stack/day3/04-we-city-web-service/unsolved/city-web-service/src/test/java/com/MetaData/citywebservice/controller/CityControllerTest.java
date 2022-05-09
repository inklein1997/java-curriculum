package com.MetaData.citywebservice.controller;

import com.MetaData.citywebservice.model.City;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {

    @Autowired
    MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldReturnCityAndRespondWithStatusOfIsCreated() throws Exception {
        City output = new City("San Francisco", "California", 874961, false);
        City input = new City("San Francisco", "California", 874961, false);

        String outputJson = mapper.writeValueAsString(output);
        String inputJson = mapper.writeValueAsString(input);

        mockMvc.perform(post("/city")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(content().string(outputJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldDeleteCityByNameWithStatusOfNoContent() throws Exception {
        mockMvc.perform(delete("/city/Detroit"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldReturnAllCitiesAndHaveStatusOfOK() throws Exception {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Austin", "Texas", 950807, true));
        cities.add(new City("Dallas", "Texas", 1331000, false));
        cities.add(new City("Detroit", "Michigan", 674841, false));
        cities.add(new City("Miami", "Florida", 454279, false));
        cities.add(new City("Atlanta", "Georgia", 488800, true));

        String citiesJson = mapper.writeValueAsString(cities);

        mockMvc.perform(get("/city"))
                .andDo(print())
                .andExpect(content().string(citiesJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnCityByNameAndHaveStatusOfOK() throws Exception {
        City miami = new City("Miami", "Florida", 454279, false);

        String miamiJson = mapper.writeValueAsString(miami);

        mockMvc.perform(get("/city/Miami"))
                .andDo(print())
                .andExpect(content().string(miamiJson))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn400StatusCodeWhenSearchingByNameThatDoesNotExist() throws Exception {
        mockMvc.perform(get("/city/Beijing"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}