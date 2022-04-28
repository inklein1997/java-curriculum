package com.company;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LargestCitiesTest {

    private Map<String, City> cities;

    @Before
    public void setUp() {
        City newYork = new City("New York", 8654321);
        City losAngeles = new City("Los Angeles", 4563218);
        City chicago = new City( "Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        cities = new HashMap<>();

        cities.put("New York", newYork);
        cities.put("California", losAngeles);
        cities.put("Illinois", chicago);
        cities.put("Colorado", denver);
        cities.put("Iowa", desMoines);
        cities.put("Georgia", atlanta);
    }

    @Test
    public void shouldFilterMapWhenGivenAPopulationLimit() {
        Map<String, City> filtered = LargestCities.filterByPopulation(cities, 2500000);
        assertEquals(3, filtered.size());
        assertTrue(filtered.containsKey("New York"));
        assertTrue(filtered.containsKey("California"));
        assertTrue(filtered.containsKey("Illinois"));

        filtered = LargestCities.filterByPopulation(cities, 0);
        assertEquals(cities, filtered);

        filtered = LargestCities.filterByPopulation(cities, 1000000000);
        assertTrue(filtered.isEmpty());
    }
}
