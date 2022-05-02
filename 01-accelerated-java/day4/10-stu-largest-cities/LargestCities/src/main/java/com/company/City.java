package com.company;

public class City {
    public City(String city, int population) {
        this.city = city;
        this.population = population;
    }

    public String city;
    public int population;

    public String getCity() {
        return city;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "City{" +
                "city='" + city + '\'' +
                ", population=" + population +
                '}';
    }
}
