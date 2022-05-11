package com.company.coffeeroaster.controller;

import com.company.coffeeroaster.dto.Coffee;
import com.company.coffeeroaster.dto.Roaster;
import com.company.coffeeroaster.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoffeeController {

    @Autowired
    CoffeeRepository repo;

    @GetMapping("/coffee")
    @ResponseStatus(HttpStatus.OK)
    public List<Coffee> GetAllCoffees(@RequestParam(required = false) String type, @RequestParam(required = false) Integer roasterId) {
        if (type != null && roasterId != null) {
            return repo.findByTypeAndRoasterId(type, roasterId);
        }

        if (type != null) {
            return repo.findByType(type);
        }

        if (roasterId != null) {
            return repo.findByRoasterId(roasterId);
        }

        return repo.findAll();
    }

    @GetMapping("/coffee/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Coffee> getSingleCoffee(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/coffee")
    @ResponseStatus(HttpStatus.CREATED)
    public Coffee createCoffee(@RequestBody Coffee coffee) {
        return repo.save(coffee);
    }

    @PutMapping("/coffee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCoffee(@PathVariable Integer id, @RequestBody Coffee coffee) {
        if(coffee.getId() == null) {
            coffee.setId(id);
        }
        if (coffee.getId() != id) {
            throw new IllegalArgumentException("Car ID must match paramter given");
        }
        repo.save(coffee);
    }

    @DeleteMapping("/coffee/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCoffee(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
