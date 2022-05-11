package com.company.dao;

import com.company.dto.Coffee;
import com.company.dto.Roaster;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
    }

    @Test
    @Transactional
    public void shouldAddAndFindById() {
        Roaster roaster = new Roaster();

        roaster.setName("Perd");
        roaster.setStreet("Broad St");
        roaster.setCity("Savannah");
        roaster.setState("GA");
        roaster.setPostalCode("31401");
        roaster.setPhone("912-555-5555");
        roaster.setEmail("perd@perdroasters.com");
        roaster.setNote("Really good!");

        roasterRepo.save(roaster);

        Coffee coffee = new Coffee();

        coffee.setRoasterId(roaster.getId());
        coffee.setName("Juggernaut");
        coffee.setCount(5);
        coffee.setUnitPrice(new BigDecimal("11.50"));

        coffee = coffeeRepo.save(coffee);

        Coffee fromRepo = coffeeRepo.findById(coffee.getId()).get();
        assertEquals(coffee, fromRepo);
    }

    @Test
    @Transactional
    public void shouldDeleteCoffee() {
        Roaster roaster = new Roaster();

        roaster.setName("Perd");
        roaster.setStreet("Broad St");
        roaster.setCity("Savannah");
        roaster.setState("GA");
        roaster.setPostalCode("31401");
        roaster.setPhone("912-555-5555");
        roaster.setEmail("perd@perdroasters.com");
        roaster.setNote("Really good!");

        roasterRepo.save(roaster);

        Coffee coffee = new Coffee();

        coffee.setRoasterId(roaster.getId());
        coffee.setName("Juggernaut");
        coffee.setCount(5);
        coffee.setUnitPrice(new BigDecimal("11.50"));

        coffee = coffeeRepo.save(coffee);

        coffeeRepo.deleteById(coffee.getId());

        Optional<Coffee> fromRepo = coffeeRepo.findById(coffee.getId());
        assertFalse(fromRepo.isPresent());
    }

    @Test
    @Transactional
    public void shouldUpdateCoffee() {
        Roaster roaster = new Roaster();

        roaster.setName("Perd");
        roaster.setStreet("Broad St");
        roaster.setCity("Savannah");
        roaster.setState("GA");
        roaster.setPostalCode("31401");
        roaster.setPhone("912-555-5555");
        roaster.setEmail("perd@perdroasters.com");
        roaster.setNote("Really good!");

        roasterRepo.save(roaster);

        Coffee coffee = new Coffee();

        coffee.setRoasterId(roaster.getId());
        coffee.setName("Juggernaut");
        coffee.setCount(5);
        coffee.setUnitPrice(new BigDecimal("11.50"));

        coffeeRepo.save(coffee);

        coffee.setName("Gemini");
        coffee.setUnitPrice(new BigDecimal("10.75"));

        coffeeRepo.save(coffee);

        Coffee coffee1 = coffeeRepo.getOne(coffee.getId());

        assertEquals(coffee1, coffee);
    }

    @Test
    @Transactional
    public void shouldFindByRoasterId() {

        Roaster roaster = new Roaster();

        roaster.setName("Perd");
        roaster.setStreet("Broad St");
        roaster.setCity("Savannah");
        roaster.setState("GA");
        roaster.setPostalCode("31401");
        roaster.setPhone("912-555-5555");
        roaster.setEmail("perd@perdroasters.com");
        roaster.setNote("Really good!");

        Roaster roaster2 = new Roaster();

        roaster2.setName("John's");
        roaster2.setStreet("Price St");
        roaster2.setCity("Atlanta");
        roaster2.setState("GA");
        roaster2.setPostalCode("30332");
        roaster2.setPhone("404-555-5555");
        roaster2.setEmail("john@johnsroaster.com");
        roaster2.setNote("PRetty alright!!");

        roasterRepo.save(roaster2);

        Coffee coffee = new Coffee();

        coffee.setRoasterId(roaster.getId());
        coffee.setName("Juggernaut");
        coffee.setCount(5);
        coffee.setUnitPrice(new BigDecimal("11.50"));

        coffeeRepo.save(coffee);

        Coffee coffee2 = new Coffee();

        coffee2.setRoasterId(roaster.getId());
        coffee2.setName("Gemini");
        coffee2.setCount(5);
        coffee2.setUnitPrice(new BigDecimal("11.50"));

        coffeeRepo.save(coffee2);

        Coffee coffee3 = new Coffee();

        coffee3.setRoasterId(roaster2.getId());
        coffee3.setName("Hoppin John");
        coffee3.setCount(5);
        coffee3.setUnitPrice(new BigDecimal("11.50"));

        coffeeRepo.save(coffee3);

        List<Coffee> perdList = coffeeRepo.findByRoasterId(roaster.getId());
        List<Coffee> johnList = coffeeRepo.findByRoasterId(roaster2.getId());

        assertEquals(2, perdList.size());
        assertEquals(1, johnList.size());

    }

    @Test
    @Transactional
    public void shouldFindByType() {

        Roaster roaster = new Roaster();

        roaster.setName("Perd");
        roaster.setStreet("Broad St");
        roaster.setCity("Savannah");
        roaster.setState("GA");
        roaster.setPostalCode("31401");
        roaster.setPhone("912-555-5555");
        roaster.setEmail("perd@perdroasters.com");
        roaster.setNote("Really good!");

        Roaster roaster2 = new Roaster();

        roaster2.setName("John's");
        roaster2.setStreet("Price St");
        roaster2.setCity("Atlanta");
        roaster2.setState("GA");
        roaster2.setPostalCode("30332");
        roaster2.setPhone("404-555-5555");
        roaster2.setEmail("john@johnsroaster.com");
        roaster2.setNote("PRetty alright!!");

        roasterRepo.save(roaster2);

        Coffee coffee = new Coffee();

        coffee.setRoasterId(roaster.getId());
        coffee.setName("Juggernaut");
        coffee.setCount(5);
        coffee.setUnitPrice(new BigDecimal("11.50"));
        coffee.setType("Bold");

        coffeeRepo.save(coffee);

        Coffee coffee2 = new Coffee();

        coffee2.setRoasterId(roaster.getId());
        coffee2.setName("Gemini");
        coffee2.setCount(5);
        coffee2.setUnitPrice(new BigDecimal("11.50"));
        coffee2.setType("Breakfast");

        coffeeRepo.save(coffee2);

        Coffee coffee3 = new Coffee();

        coffee3.setRoasterId(roaster2.getId());
        coffee3.setName("Hoppin John");
        coffee3.setCount(5);
        coffee3.setUnitPrice(new BigDecimal("11.50"));
        coffee3.setType("Bold");

        coffeeRepo.save(coffee3);

        List<Coffee> boldList = coffeeRepo.findByType("Bold");
        List<Coffee> breakfastList = coffeeRepo.findByType("Breakfast");

        assertEquals(2, boldList.size());
        assertEquals(1, breakfastList.size());

    }

    @Test
    @Transactional
    public void shouldFindByRoasterIdAndType() {

        Roaster roaster = new Roaster();

        roaster.setName("Perd");
        roaster.setStreet("Broad St");
        roaster.setCity("Savannah");
        roaster.setState("GA");
        roaster.setPostalCode("31401");
        roaster.setPhone("912-555-5555");
        roaster.setEmail("perd@perdroasters.com");
        roaster.setNote("Really good!");

        Roaster roaster2 = new Roaster();

        roaster2.setName("John's");
        roaster2.setStreet("Price St");
        roaster2.setCity("Atlanta");
        roaster2.setState("GA");
        roaster2.setPostalCode("30332");
        roaster2.setPhone("404-555-5555");
        roaster2.setEmail("john@johnsroaster.com");
        roaster2.setNote("PRetty alright!!");

        roasterRepo.save(roaster2);

        Coffee coffee = new Coffee();

        coffee.setRoasterId(roaster.getId());
        coffee.setName("Juggernaut");
        coffee.setCount(5);
        coffee.setUnitPrice(new BigDecimal("11.50"));
        coffee.setType("Bold");

        coffeeRepo.save(coffee);

        Coffee coffee2 = new Coffee();

        coffee2.setRoasterId(roaster.getId());
        coffee2.setName("Gemini");
        coffee2.setCount(5);
        coffee2.setUnitPrice(new BigDecimal("11.50"));
        coffee2.setType("Breakfast");

        coffeeRepo.save(coffee2);

        Coffee coffee3 = new Coffee();

        coffee3.setRoasterId(roaster2.getId());
        coffee3.setName("Hoppin John");
        coffee3.setCount(5);
        coffee3.setUnitPrice(new BigDecimal("11.50"));
        coffee3.setType("Bold");

        coffeeRepo.save(coffee3);

        List<Coffee> boldList = coffeeRepo.findByRoasterIdAndType(roaster.getId(),"Bold");
        List<Coffee> breakfastList = coffeeRepo.findByRoasterIdAndType(roaster.getId(), "Breakfast");

        assertEquals(1, boldList.size());
        assertEquals(1, breakfastList.size());

    }

}
