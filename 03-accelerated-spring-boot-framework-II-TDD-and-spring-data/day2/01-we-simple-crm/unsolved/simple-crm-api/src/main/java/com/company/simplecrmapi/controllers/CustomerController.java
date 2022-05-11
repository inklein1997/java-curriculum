package com.company.simplecrmapi.controllers;

import com.company.simplecrmapi.dto.Customer;
import com.company.simplecrmapi.repository.CustomerRepository;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;

    @RequestMapping(value="/customer", method= RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers(@RequestParam(required=false) String company, @RequestParam(required=false) String lastName) {
        if (company != null && lastName != null) {

//            List<Customer> LastNames = customerRepository.findByLastName(lastName);
//            List<Customer> results = new ArrayList<>();
//
//            for (int i = 0; i < LastNames.size(); i++) {
//                if (LastNames.get(i).getCompany().equals(company)) {
//                    results.add(LastNames.get(i));
//                }
//            }
//
//            return results;

            return customerRepository.findByLastNameAndCompany(lastName, company);
        }
        if (lastName != null) {
            return customerRepository.findByLastName(lastName);
        }
        if (company != null) {
            return customerRepository.findByCompany(company);
        }
        return customerRepository.findAll();
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerRepository.save(customer);
    }

}
