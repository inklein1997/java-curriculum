package com.example.customerdataservice.controller;

import com.example.customerdataservice.model.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataLoaderController {
    @Autowired
    CustomerRepository repo;

    @GetMapping("/load-data")
    public void loadData() {
        Customer customer = new Customer();
        customer.setFirstName("Jane");
        customer.setLastName("Smith");
        customer.setStreet("123 Main Street");
        customer.setCity("HomeTown");
        customer.setState("NY");
        customer.setZipcode("12345");
        customer.setLevel("Gold");
        repo.save(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Mya");
        customer1.setLastName("JOnes");
        customer1.setStreet("2222 Elm Street");
        customer1.setCity("Small Town");
        customer1.setState("MS");
        customer1.setZipcode("11223");
        customer1.setLevel("Gold");
        repo.save(customer1);

        Customer customer2 = new Customer();
        customer2.setFirstName("Doug");
        customer2.setLastName("Johnson");
        customer2.setStreet("246 West Avenue");
        customer2.setCity("Big City");
        customer2.setState("NY");
        customer2.setZipcode("54321");
        customer2.setLevel("Silver");
        repo.save(customer2);
    }
}
