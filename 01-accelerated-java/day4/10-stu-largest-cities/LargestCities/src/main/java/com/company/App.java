package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {

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

        for (Map.Entry<String, City> entry : cityMap.entrySet()) {
            System.out.println(entry);
        }





    }

    public static Map<String, City> filterByPopulation(HashMap<String, City> cityMap, int population) {
        Map<String, City> newMap = new HashMap<>();

        Set<String> keys = cityMap.keySet();

        for(String key : keys) {
            City city = cityMap.get(key);
            if(city.getPopulation() > population) {
                newMap.put(key, city);
            }
        }

        return newMap;
    }
}
