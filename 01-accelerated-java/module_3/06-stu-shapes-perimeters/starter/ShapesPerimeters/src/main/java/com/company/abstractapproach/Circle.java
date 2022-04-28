package com.company.abstractapproach;

public class Circle extends Shape {
    public Circle(String name, String color, int xCoord, int yCoord, double radius) {
        super(name, color, xCoord, yCoord);
        this.radius = radius;
    }
    private double radius;

    public void area() {
        double areaCircle = 3.14 * radius * radius;
        System.out.println("The area of the circle is " + areaCircle);
    };

    public void perimeter() {
        double perimeterCircle = 2 * 3.14 * radius;
        System.out.println("The perimeter of the circle is " + perimeterCircle);
    }
}
