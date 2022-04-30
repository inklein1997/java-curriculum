package com.company;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


public class App {

    public static void main(String[] args) {

        try {

            List<Television> tvList;

            tvList = FileIO.getTelevisions("televisions.csv");

            // All TVs with screens larger than 60 inches
            tvList.stream()
                    .filter(t -> t.getScreenSize() > 60)
                    .forEach(tv -> {
                        System.out.println("===============");
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Screen Size: " + tv.getScreenSize());
                        System.out.println("Price: " + tv.getPrice());

                    });

            System.out.println("***********************");

            // Grouped by Brand
            Map<String, List<Television>> groupedTVs =
                    tvList.stream()
                            .collect(Collectors.groupingBy(t -> t.getBrand()));

            Set<String> keys = groupedTVs.keySet();
            for(String key : keys) {
                System.out.println(key);
            }

            System.out.println("***********************");

            // Average screen size
            double avgScreenSize =
                    tvList
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .average()
                            .getAsDouble();

            System.out.println("Average screen size is: " + avgScreenSize);

            System.out.println("***********************");

            // Largest screen size

            int maxScreenSize =
                    tvList
                            .stream()
                            .mapToInt(t -> t.getScreenSize())
                            .max()
                            .getAsInt();

            System.out.println("Largest screen size is: " + maxScreenSize);


            // Challenge
            // Sorted by screen size

            tvList.stream()
                    .sorted(Comparator.comparingInt(Television::getScreenSize))
                    .forEach(tv -> {
                        System.out.println("===============");
                        System.out.println("Brand: " + tv.getBrand());
                        System.out.println("Model: " + tv.getModel());
                        System.out.println("Screen Size: " + tv.getScreenSize());
                        System.out.println("Price: " + tv.getPrice());
                    });

        } catch (IOException e) {
            System.out.println("ERROR: Problem encountered reading JSON file - " + e.getMessage());
        }
    }
}
