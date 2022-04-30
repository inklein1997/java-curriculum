package com.company;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws FileNotFoundException {

        // CODE GOES HERE
        FileIO fileIO = new FileIO();
        List<Television> tvList = fileIO.getTelevisions();
        tvList.stream().filter(tv -> tv.getScreenSize() > 60).forEach(tv -> System.out.println(tv));

        Map<String, List<Television>> tvMap = tvList.stream().collect(Collectors.groupingBy(tv -> tv.getBrand()));

        System.out.println(tvMap.keySet());

        double average = tvList.stream().mapToInt(tv -> tv.getScreenSize()).average().getAsDouble();
        System.out.println(average);


    }
}
