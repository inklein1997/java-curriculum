package com.example.customerdataservice.controller;

import com.example.customerdataservice.model.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        Optional<Customer> returnVal = repo.findById(id);
        if (returnVal.isPresent()) {
            return returnVal.get();
        } else {
            return null;
        }
    }

    @GetMapping("/customers/level/{level}")
    public List<Customer> getCustomersByLevel(@PathVariable String level) {
        return repo.findAllCustomersByLevel(level);
    }

    @GetMapping("/customers/state/{state}")
    public List<Customer> getCustomersByState(@PathVariable String state) {
        return repo.findAllCustomersByState(state);
    }

    @PutMapping("/customers")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer) {
        repo.save(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        repo.deleteById(id);
    }


}
