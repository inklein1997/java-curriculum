package com.company.simplecrmapi.repository;

import com.company.simplecrmapi.dto.Customer;
import com.company.simplecrmapi.dto.Note;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    CustomerRepository customerRepo;

    @Autowired
    NoteRepository noteRepo;

    @Before
    public void setUp() {
        customerRepo.deleteAll();
        noteRepo.deleteAll();
    }

    @Test
    public void shouldSaveNotesWithCustomer() {
        // Arrange
        // need to set up customer
        Customer customer = new Customer();
        customer.setFirstName("Henry");
        customer.setLastName("Ford");
        customer.setCompany("Ford Motor Company");
        customer.setPhone("7732029999");

        // need to set up notes
        Note note1 = new Note();
        note1.setContent("Seems interested in black paint.");

        Note note2 = new Note();
        note2.setContent("Wants to create some sort of line or workers to assemble products.");

        // put the customer in the database
        // NOTE! After this call, customer will have its id set properly (no need to check return value)
        customer = customerRepo.save(customer);

        // set the customer id on the notes
        note1.setCustomerId(customer.getId());
        note2.setCustomerId(customer.getId());

        // put the notes in the database
        // NOTE! After this call, note will have its id set properly (no need to check return value)
        noteRepo.save(note1);
        noteRepo.save(note2);

        // Create a set of notes for comparison with the result
        Set<Note> noteSet = new HashSet<>();
        noteSet.add(note1);
        noteSet.add(note2);

        customer.setNotes(noteSet);

        // Act
        // query for customer
        List<Customer> customerList = customerRepo.findAll();

        // Assert
        // notes should be included with customer record
        assertEquals(customer, customerList.get(0));
    }

    @Test
    public void shouldQueryByLastNameAndCompany() {
        // Arrange
        // put some data in the database
            // put at least one customer in the database
            // three customers: two that share the same last name, and overlap with two that share the same company.
        // create my expected output list
        Customer customer1 = new Customer("Melinda", "Gates", "B&MG Foundation", "9998887777", new HashSet<>());
        Customer customer2 = new Customer("Bill", "Gates", "Microsoft", "1112223333", new HashSet<>());
        Customer customer3 = new Customer("Steve", "Ballmer", "Microsoft", "4445556666", new HashSet<>());

        customerRepo.save(customer1);
        customerRepo.save(customer2);
        customerRepo.save(customer3);

        List<Customer> expectedResults = new ArrayList<>();
        expectedResults.add(customer2);

        // Act
        // Call method that queries by lastName and company
        List <Customer> actualResults = customerRepo.findByLastNameAndCompany("Gates", "Microsoft");

        // Assert
        assertEquals(expectedResults, actualResults);
    }
}