package com.company;

import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class App {
    public void printKeys(HashMap<String, String> map) {
        for (String key : map.keySet()) {
            System.out.println(key);
        }
    }

    public void printValues(HashMap<String, String> map) {
        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    public void printKeysAndValues(HashMap<String, String> map) {
        for ( Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public Map mapFun(Map <String, Integer> map) {
        map.put("Ford Explorer", 2012);
        map.put("Smart Fortwo", 2013);
        map.remove("Jeep Wrangler");
        return map;
    }

    public Map<String, List<Car>> listCars(List<Car> car) {
        List toyotaList = new ArrayList<>();
        List fordList = new ArrayList<>();
        List hondaList = new ArrayList<>();

        Map<String, List<Car>> carMap = new HashMap<>();
        carMap.put("Toyota", toyotaList);
        carMap.put("Ford", fordList);
        carMap.put("Honda", hondaList);

        return carMap;
    }

}
