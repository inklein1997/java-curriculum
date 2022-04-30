package com.company;

public class App {
    public static void main(String[] args) {
        Lion lion1 = new Lion("Simba", 4, 230);
        Lion lion2 = new Lion("Nala", 4,210);

        System.out.println(lion1.getName());
        System.out.println(lion2.getWeight());

        System.out.println(lion1.describe());
        System.out.println(lion2.describe());

        lion2.roar(2);
        lion2.pounce();
        lion2.eat(20);
        lion2.roar(1);

        System.out.println(lion1.describe());
        System.out.println(lion2.describe());
    }
}
