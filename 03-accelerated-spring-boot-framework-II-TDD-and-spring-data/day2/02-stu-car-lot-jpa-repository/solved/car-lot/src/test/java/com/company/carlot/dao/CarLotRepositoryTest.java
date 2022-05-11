package com.company.carlot.dao;

import com.company.carlot.dto.Car;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarLotRepositoryTest {

    @Autowired
    CarLotRepository carLotRepo;

    private Car car;
    private Car car2;
    private Car car3;

    @Before
    public void setUp() {
        carLotRepo.deleteAll();

        car = new Car();

        car.setMake("Toyota");
        car.setModel("Sienna");
        car.setYear("2019");
        car.setColor("Orange");

        car2 = new Car();

        car2.setMake("Toyota");
        car2.setModel("Rav4");
        car2.setYear("2019");
        car2.setColor("Red");

        car3 = new Car();

        car3.setMake("Ford");
        car3.setModel("Fusion");
        car3.setYear("2019");
        car3.setColor("Orange");
    }

    @Test
    public void shouldAddAndGetCarFromDatabase() {

        car = carLotRepo.save(car);

        Car fromRepo = carLotRepo.findById(car.getId()).get();
        assertEquals(car, fromRepo);
    }

    @Test
    public void shouldUpdateCarInDatabase() {

        carLotRepo.save(car);

        car.setColor("Red");

        car = carLotRepo.save(car);

        Car fromRepo = carLotRepo.findById(car.getId()).get();
        assertEquals(car, fromRepo);
    }

    @Test
    public void shouldDeleteCarFromDatabase() {

        car = carLotRepo.save(car);

        carLotRepo.deleteById(car.getId());

        Optional<Car> fromRepo = carLotRepo.findById(car.getId());

        assertFalse(fromRepo.isPresent());
    }

    @Test
    public void shouldFindCarsByColor() {

        carLotRepo.save(car);
        carLotRepo.save(car2);
        carLotRepo.save(car3);

        List<Car> carList = carLotRepo.findByColor("Orange");
        List<Car> carList2 = carLotRepo.findByColor("Red");
        List<Car> carList3 = carLotRepo.findByColor("Blue");

        assertEquals(2, carList.size());
        assertEquals(1, carList2.size());
        assertEquals(0, carList3.size());
    }

    @Test
    public void shouldFindCarsByMake() {

        carLotRepo.save(car);
        carLotRepo.save(car2);
        carLotRepo.save(car3);

        List<Car> carList = carLotRepo.findByMake("Toyota");
        List<Car> carList2 = carLotRepo.findByMake("Ford");
        List<Car> carList3 = carLotRepo.findByMake("Honda");

        assertEquals(2, carList.size());
        assertEquals(1, carList2.size());
        assertEquals(0, carList3.size());
    }

    @Test
    public void shouldFindCarsByMakeAndColor() {

        carLotRepo.save(car);
        carLotRepo.save(car2);
        carLotRepo.save(car3);

        List<Car> carList = carLotRepo.findByMakeAndColor("Toyota", "Orange");
        List<Car> carList2 = carLotRepo.findByMakeAndColor("Toyota", "Red");
        List<Car> carList3 = carLotRepo.findByMakeAndColor("Ford", "Blue");

        assertEquals(1, carList.size());
        assertEquals(1, carList2.size());
        assertEquals(0, carList3.size());
    }

}
