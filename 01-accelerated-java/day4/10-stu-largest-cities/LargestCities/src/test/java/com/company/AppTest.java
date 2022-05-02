package com.company;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void shouldFilterByPopulation() {
        City newYork = new City("New York", 8654321);
        City losAngeles = new City("losAngeles", 4563218);
        City chicago = new City("Chicago", 2716520);
        City denver = new City("Denver", 704621);
        City desMoines = new City("Des Moines", 217521);
        City atlanta = new City("Atlanta", 486213);

        Map<String, City> cityMap = new HashMap<String, City>();

        cityMap.put("New York", newYork);
        cityMap.put("California", losAngeles);
        cityMap.put("Illinois", chicago);
        cityMap.put("Colorado", denver);
        cityMap.put("Maine", desMoines);
        cityMap.put("Georgia", atlanta);


    }
}