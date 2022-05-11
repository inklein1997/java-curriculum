package com.company.carlot.controllers;

import com.company.carlot.dto.Car;
import com.company.carlot.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CarController {

    @Autowired
    CarRepository repo;

    @GetMapping("/cars")
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getAllCars(@RequestParam(required = false) String make, @RequestParam(required = false) String color) {
        if (make != null && color != null) {
            return repo.findByMakeAndColor(make, color);
        }

        if (make != null) {
            return repo.findByMake(make);
        }

        if (color != null) {
            return repo.findByColor(color);
        }

        return repo.findAll();
    }

    @GetMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Car> getSingleCar(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/cars")
    @ResponseStatus(HttpStatus.CREATED)
    public Car createCar(@RequestBody Car car) {
        return repo.save(car);
    }

    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCar(@PathVariable Integer id, @RequestBody Car car) {
        if(car.getId() == null) {
            car.setId(id);
        }
        if (car.getId() != id) {
            throw new IllegalArgumentException("Car ID must match paramter given");
        }

        repo.save(car);
    }

    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
