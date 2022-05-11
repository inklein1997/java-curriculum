package com.example.customerdataservice.repository;

import com.example.customerdataservice.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoTests {

    @Autowired
    CustomerRepository customerRepo;

    @Before
    public void setUp() throws Exception {
        customerRepo.deleteAll();

        customerRepo.save(new Customer("Trevor", "Peterson", "123 Statically Typed Street",
                "Chicago", "Illinois", "60601", "Infinity"));
        customerRepo.save(new Customer("Dan", "Mueller", "321 Boolean Algebra Boulevard",
                "Chicago", "Illinois", "60601", "Super Infinity"));
        customerRepo.save(new Customer("Jason", "Summers", "555 Arrange Act Assert Avenue",
                "Phoenix", "Arizona", "85001", "Super Infinity"));
    }

    @Test
    public void shouldFindAllCustomersByState() {
        List<Customer> illinoisCustomers = customerRepo.findAllCustomersByState("Illinois");

        assertEquals(2, illinoisCustomers.size());
    }

    @Test
    public void shouldFindAllCustomersByLevel() {
        List<Customer> superInfinityCustomers = customerRepo.findAllCustomersByLevel("Super Infinity");

        assertEquals(2, superInfinityCustomers.size());
    }
}
