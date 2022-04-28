package com.company;

import java.util.*;

public class App {

    public void printKeys(Map<String, String> map) {
        Set<String> myKeys = map.keySet();
        for (String key : myKeys) {
            System.out.println(key);
        }
    }

    public void printValues(Map<String, String> map) {
        Collection<String> myValues = map.values();
        for (String value : myValues) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(Map<String, String> map) {
        Set<Map.Entry<String, String>> myEntries = map.entrySet();
        for (Map.Entry<String, String> entry : myEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public Map<String, Integer> mapFun(Map<String, Integer> map) {
        map.put("Ford Explorer", 2012);
        map.put("Smart Fortwo", 2013);

        map.remove("Jeep Wrangler");

        return map;
    }

    public Map<String, List<Car>> listCars(List<Car> cars) {
        List<Car> toyotaList = new ArrayList<>();
        List<Car> fordList = new ArrayList<>();
        List<Car> hondaList = new ArrayList<>();

        for(Car car: cars) {
            if (car.getMake().equals("Toyota")) {
                toyotaList.add(car);
            } else if (car.getMake().equals("Ford")) {
                fordList.add(car);
            } else if (car.getMake().equals("Honda")) {
                hondaList.add(car);
            }
        }

        Map<String, List<Car>> carMap = new HashMap<>();

        carMap.put("Toyota", toyotaList);
        carMap.put("Ford", fordList);
        carMap.put("Honda", hondaList);

        return carMap;
    }
}
