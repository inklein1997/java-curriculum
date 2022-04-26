package com.company;

public class Lion {
    private String name;
    private int age;
    private int weight;

    public Lion(String nameIn, int ageIn, int weightIn) {
        this.name = nameIn;
        this.age = ageIn;
        this.weight = weightIn;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void roar() {
        System.out.println("ROAR");
    }

    public void pounce() {
        System.out.println("POUNCING");
    }

    public void nap() {
        System.out.println("ZzzZzzZzz");
    }
}
