package com.example.customerdataservice.controller;

import com.example.customerdataservice.model.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
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
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerRepository customerRepo;

    private ObjectMapper mapper = new ObjectMapper();

    Customer inputTrevor;
    Customer outputTrevor;
    Customer outputDan;
    Customer outputJason;

    List<Customer> superInfinityCustomers;
    List<Customer> illinoisCustomers;

    @Before
    public void setUp() throws Exception {
        inputTrevor = new Customer("Trevor", "Peterson", "123 Statically Typed Street",
                "Chicago", "Illinois", "60601", "Infinity");
        outputTrevor = new Customer("Trevor", "Peterson", "123 Statically Typed Street",
                "Chicago", "Illinois", "60601", "Infinity");
        outputTrevor.setCustomerId(1l);
        outputDan = new Customer("Dan", "Mueller", "321 Boolean Algebra Boulevard",
                "Chicago", "Illinois", "60601", "Super Infinity");
        outputDan.setCustomerId(2l);
        outputJason = new Customer("Jason", "Summers", "555 Arrange Act Assert Avenue",
                "Phoenix", "Arizona", "85001", "Super Infinity");
        outputJason.setCustomerId(3l);

        superInfinityCustomers = new ArrayList<>(Arrays.asList(
                outputDan,
                outputJason
        ));

        illinoisCustomers = new ArrayList<>(Arrays.asList(
                outputTrevor,
                outputDan
        ));

        doReturn(outputTrevor).when(customerRepo).save(inputTrevor);
        doReturn(Optional.of(outputTrevor)).when(customerRepo).findById(1l);
        doReturn(superInfinityCustomers).when(customerRepo).findAllCustomersByLevel("Super Infinity");
        doReturn(illinoisCustomers).when(customerRepo).findAllCustomersByState("Illinois");
    }

    @Test
    public void shouldAddCustomerOnPostRequest() throws Exception {
        String inputJson = mapper.writeValueAsString(inputTrevor);
        String outputJson = mapper.writeValueAsString(outputTrevor);

        mockMvc.perform(post("/customers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetCustomerById() throws Exception {
        String outputJson = mapper.writeValueAsString(outputTrevor);

        mockMvc.perform(get("/customers/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetCustomersByLevel() throws Exception {
        String outputJson = mapper.writeValueAsString(superInfinityCustomers);

        mockMvc.perform(get("/customers/level/Super Infinity"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetCustomersByState() throws Exception {
        String outputJson = mapper.writeValueAsString(illinoisCustomers);

        mockMvc.perform(get("/customers/state/Illinois"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldRespondWith204WhenUpdatingCustomer() throws Exception {
        inputTrevor.setCustomerId(1l);
        inputTrevor.setStreet("5200 Dynamically Typed Drive");

        String inputJson = mapper.writeValueAsString(inputTrevor);

        mockMvc.perform(put("/customers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldRespondWith204WhenDeletingCustomer() throws Exception {
        mockMvc.perform(delete("/customers/1"))
                .andExpect(status().isNoContent());
    }
}
