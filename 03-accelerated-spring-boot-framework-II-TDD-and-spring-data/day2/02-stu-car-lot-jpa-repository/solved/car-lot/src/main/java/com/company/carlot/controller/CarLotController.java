package com.company.carlot.controller;

import com.company.carlot.dao.CarLotRepository;
import com.company.carlot.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cars")
public class CarLotController {

    @Autowired
    private CarLotRepository carlotRepo;

    @PostMapping
    public Car createCar(@RequestBody Car car) {
        carlotRepo.save(car);
        return car;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carlotRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Car getCarById(@PathVariable int id) {
        Optional<Car> car = carlotRepo.findById(id);

        if (!car.isPresent()) {
            return null;
        }

        return car.get();
    }

    @PutMapping(value = "/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable int id) {
        if(car.getId() == null) {
            car.setId(id);
        }

        if(car.getId() != id) {
            throw new IllegalArgumentException("Car ID must match parameter given");
        }
        carlotRepo.save(car);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable int id) {
        carlotRepo.deleteById(id);
    }

}
