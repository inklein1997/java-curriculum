package com.company.coffeeroaster.controller;

import com.company.coffeeroaster.dto.Coffee;
import com.company.coffeeroaster.dto.Roaster;
import com.company.coffeeroaster.repository.CoffeeRepository;
import com.company.coffeeroaster.repository.RoasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RoasterController {

    @Autowired
    RoasterRepository repo;

    @GetMapping("/roaster")
    @ResponseStatus(HttpStatus.OK)
    public List<Roaster> getAllRoasters() {
        return repo.findAll();
    }

    @GetMapping("/roaster/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Roaster> getSingleRoaster(@PathVariable Integer id) {
        return repo.findById(id);
    }

    @PostMapping("/roaster")
    @ResponseStatus(HttpStatus.CREATED)
    public Roaster createRoaster(@RequestBody Roaster roaster) {
        return repo.save(roaster);
    }

    @PutMapping("/roaster/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateRoaster(@PathVariable Integer id, @RequestBody Roaster roaster) {
        if(roaster.getId() == null) {
            roaster.setId(id);
        }
        if (roaster.getId() != id) {
            throw new IllegalArgumentException("Car ID must match paramter given");
        }
        repo.save(roaster);
    }

    @DeleteMapping("/roaster/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoaster(@PathVariable Integer id) {
        repo.deleteById(id);
    }
}
