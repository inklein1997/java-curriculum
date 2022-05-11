package com.example.customerdataservice.repository;

import com.example.customerdataservice.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllCustomersByState(String state);
    List<Customer> findAllCustomersByLevel(String level);
}
