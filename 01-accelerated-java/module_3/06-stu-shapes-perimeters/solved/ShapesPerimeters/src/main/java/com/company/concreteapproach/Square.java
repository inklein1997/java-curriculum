package com.company.concreteapproach;

public class Square extends Shape {

    private double side;

    public Square(String name, String color, int xCoord, int yCoord, double side) {
        super(name, color, xCoord, yCoord);
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    public double perimeter() {
        return 4 * side;
    }

    public double getSide() {
        return side;
    }
}
