package com.MetaData.citywebservice.controller;

import com.MetaData.citywebservice.model.City;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class CityController {
    List<City> cities;
    boolean wasFound = false;

    public CityController() {
        cities = new ArrayList<>();
        cities.add(new City("Austin", "Texas", 950807, true));
        cities.add(new City("Dallas", "Texas", 1331000, false));
        cities.add(new City("Detroit", "Michigan", 674841, false));
        cities.add(new City("Miami", "Florida", 454279, false));
        cities.add(new City("Atlanta", "Georgia", 488800, true));
    }

    @RequestMapping(value = "/city", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public City addCityToList(@Valid @RequestBody City city) {
        cities.add(city);
        return city;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCityFromList(@PathVariable String name) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(name)) {
                cities.remove(i);
                wasFound = true;
            }
        }
        if (wasFound == false) {
            throw new IllegalArgumentException("That city does not currently exist");
        }

    }

    @RequestMapping(value = "/city", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List getAllCities() {
        return cities;
    }

    @RequestMapping(value = "/city/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public City getCityByName(@PathVariable String name) {
        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i).getName().equals(name)) {
                return cities.get(i);
            }
        }
        throw new IllegalArgumentException("That city does not currently exist!");
    }
}
