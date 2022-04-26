package com.company;

public class App {
    public static void main(String[] args) {

        Student jim = new Student();
        jim.setName("Jim");
        jim.setGpa(2.75);

        Student callie = new Student();
        callie.setName("Callie");
        callie.setGpa(3.9);

        jim.greet();
        callie.greet();
    }
}
