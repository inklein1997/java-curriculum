package com.company.abstractapproach;

public class Circle extends Shape {

    private double radius;

    public Circle(String name, String color, int xCoord, int yCoord, double radius) {
        super(name, color, xCoord, yCoord);
        this.radius = radius;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    public double getRadius() {
        return radius;
    }
}
