package com.company;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        try {

            List<Motorcycle> bikes = MotoFileIO.getMotorcycles("motorcycles.csv");

            // Print the information for all Suzuki motorcycles in inventory
            String make = "Suzuki";
            System.out.println("All " + make + " motorcycles in inventory: ");
            bikes
                    .stream()
                    .filter(b -> b.getMake().equals(make))
                    .forEach(bike -> {
                        System.out.println("===============");
                        System.out.println("Make: " + bike.getMake());
                        System.out.println("Model: " + bike.getModel());
                        System.out.println("Color: " + bike.getColor());
                        System.out.println("Year: " + bike.getYear());
                        System.out.println("Displacement: " + bike.getDisplacement());
                        System.out.println("Horsepower: " + bike.getHorsepower());
                        System.out.println("Weight: " + bike.getWeight());
                    });

            // Print the information for all motorcycles the weigh less than 500 pounds
            int weight = 500;
            bikes
                    .stream()
                    .filter(bike -> bike.getWeight() < weight)
                    .forEach(bike -> {
                        System.out.println("===============");
                        System.out.println("Make: " + bike.getMake());
                        System.out.println("Model: " + bike.getModel());
                        System.out.println("Color: " + bike.getColor());
                        System.out.println("Year: " + bike.getYear());
                        System.out.println("Displacement: " + bike.getDisplacement());
                        System.out.println("Horsepower: " + bike.getHorsepower());
                        System.out.println("Weight: " + bike.getWeight());
                    });

            // Rather than printing out the matching motorcycles, let's put them into a list
            List<Motorcycle> lightBikes =
                    bikes
                            .stream()
                            .filter(bike -> bike.getWeight() < weight)
                            .collect(Collectors.toList());

            System.out.println(lightBikes.size());

            // We can also group our motorcycles by Make.
            Map<String, List<Motorcycle>> groupedBikes =
                    bikes
                            .stream()
                            .collect(Collectors.groupingBy(b -> b.getMake()));

            Set<String> keys = groupedBikes.keySet();
            for(String key : keys) {
                System.out.println(key);
            }



            System.out.println("XXXXXXX");
            System.out.println("XXXXXXX");

            // Print the average horsepower of the motorcycles in inventory
            double avgHorsepower =
                    bikes
                            .stream()
                            .mapToInt(b -> b.getHorsepower())
                            .average()
                            .getAsDouble();

            System.out.println("Average horsepower is: " + avgHorsepower);

            int maxHorsePower =
                    bikes
                            .stream()
                            .mapToInt(bike -> bike.getHorsepower())
                            .max()
                            .getAsInt();

            System.out.println("Max horsepower: " + maxHorsePower);



        } catch (FileNotFoundException e) {
            System.out.println("Could not find CSV file: " + e.getMessage());
        }
    }

}
