package com.company;

public class Lion {
    private String name;
    private int age;
    private int weight;
    public static int defaultWeight = 50;
    private static int lionCount = 0;

    public Lion(String name, int age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Lion(String name, int age) {
        this.name = name;
        this.age = age;
        this.weight = defaultWeight;
        lionCount++;
    }

    public static int getLionCount() {
        return lionCount;
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

    public void roar(int volume) {
        switch(volume) {
            case 0:
                System.out.println("...");
            case 1:
                System.out.println("rar");
            case 2:
                System.out.println("ROAR");
            case 3:
                System.out.println("ROOOOOOOOOOOOOOOOOOOOOOAR");
            default:
                System.out.println("hiccup");
        }
    }

    public void pounce() {
        System.out.println("POUNCED! MISSED IT!");
    }

    public void eat(int size) {
        System.out.println("Yumsville!");
        this.weight = this.weight + size;
    }

    public String describe() {
        return name + ": a lion that weighs " + weight + " kgs.";
    }

}
