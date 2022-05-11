package com.company.coffeeroaster.repository;

import com.company.coffeeroaster.dto.Coffee;
import com.company.coffeeroaster.dto.Roaster;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoffeeRepositoryTest {

    @Autowired
    CoffeeRepository coffeeRepo;

    @Autowired
    RoasterRepository roasterRepo;

    @Before
    public void setUp() {
        coffeeRepo.deleteAll();
        roasterRepo.deleteAll();

        Roaster roaster1 = new Roaster("Dunkin donuts", new HashSet<>());
        Roaster roaster2 = new Roaster("Starbucks", new HashSet<>());

        Coffee coffee1 = new Coffee(roaster1.getId(), "Americano", "Robusta");
        Coffee coffee2 = new Coffee(roaster1.getId(), "Irish", "Arabica");
        Coffee coffee3 = new Coffee(roaster2.getId(), "Irish", "Liberica");
        Coffee coffee4 = new Coffee(roaster2.getId(), "Americano", "Arabica");

        Set<Coffee> coffeeList1 = new HashSet<>();
        coffeeList1.add(coffee1);
        coffeeList1.add(coffee2);

        Set<Coffee> coffeeList2 = new HashSet();
        coffeeList1.add(coffee3);
        coffeeList1.add(coffee4);

        roaster1.setCoffees(coffeeList1);
        roaster2.setCoffees(coffeeList2);
    }

    @Test
    public void createTest() {

    }

}