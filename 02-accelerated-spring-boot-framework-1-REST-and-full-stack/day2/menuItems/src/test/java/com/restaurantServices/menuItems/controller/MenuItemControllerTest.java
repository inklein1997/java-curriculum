package com.restaurantServices.menuItems.controller;

import com.restaurantServices.menuItems.MenuItem;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuItemController.class)  //creates a menu item controller instance to run the test on
public class MenuItemControllerTest {

    @Autowired // Inject something of that type into object.  Use instead of new;
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    @Test
    public void shouldReturnAllRecordsInCollection() throws Exception {
        mockMvc.perform(get("/menuitems"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").isNotEmpty());
    }
    @Test
    public void shouldReturnNewMenuItemOnPost() throws Exception {
        // Arrange
        MenuItem menuItemInput = new MenuItem("fries", 4.29, "delicious, golden, fried, potatoes");
        MenuItem menuItemOutput = new MenuItem(4,"fries", 4.29, "delicious, golden, fried, potatoes");

        String inputJson = mapper.writeValueAsString(menuItemInput);

        String outputJson = mapper.writeValueAsString(menuItemOutput);

        System.out.println(inputJson);
        System.out.println(outputJson);

        // Act
        mockMvc.perform(post("/menuitems")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetMenuItemById() throws Exception {
        // Arrange
        //menuItems.add(new MenuItem(menuItemId++, "Ice cream sundae", 20.00, "Two scoops, no bananas"));
        MenuItem expectedMenuItem = new MenuItem(3, "Ice cream sundae", 20.00, "Two scoops, no bananas");
        String expectedOutputJson = mapper.writeValueAsString(expectedMenuItem);

        // Act
        mockMvc.perform(get("/menuitems/3"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedOutputJson));   // Assert
    }

    @Test
    public void shouldGetMenuItemByName() throws Exception {
        // Arrange
        //menuItems.add(new MenuItem(menuItemId++, "Ice cream sundae", 20.00, "Two scoops, no bananas"));
        MenuItem expectedMenuItem = new MenuItem(2, "Cheeseburger", 12.00, "To all be fatty special sauce");
        String expectedOutputJson = mapper.writeValueAsString(expectedMenuItem);

        // Act
        mockMvc.perform(get("/menuitems/byname/cheeseburger"))
                .andDo(print())
                .andExpect(status().isOk())                 // Assert
                .andExpect(content().json(expectedOutputJson));   // Assert
    }

    @Test
    public void shouldDeleteMenuItem() throws Exception {
        mockMvc.perform(delete("/menuitems/2"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldUpdateMenuItem() throws Exception {
        MenuItem updatedMenuItem = new MenuItem("hot pocket", 14.99,"Don't burn the roof of your mouth!");
        String jsonInput = mapper.writeValueAsString(updatedMenuItem);

        int menuItemToChange = 1;
        MenuItem expectedOutputMenuItem = new MenuItem("hot pocket", 14.99,"Don't burn the roof of your mouth!");
        expectedOutputMenuItem.setId(1);
        String expectedOutputJson = mapper.writeValueAsString(expectedOutputMenuItem);

        mockMvc.perform(put("/menuitems/" + menuItemToChange)
                .content(jsonInput)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(expectedOutputJson));
    }
}