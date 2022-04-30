package com.company.concreteapproach;

public class Triangle extends Shape {

    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(String name, String color, int xCoord, int yCoord, double sideA, double sideB, double sideC) {
        super(name, color, xCoord, yCoord);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double area() {
        double p = perimeter() / 2;

        return Math.sqrt(p * (p - sideA) * (p - sideB) * (p-sideC));
    }

    public double perimeter() {
        return sideA + sideB + sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }
}
