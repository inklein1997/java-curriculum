package com.company.abstractapproach;

public class Triangle extends Shape {
    public Triangle(String name, String color, int xCoord, int yCoord, double width, double height) {
        super(name, color, xCoord, yCoord);
        this.width = width;
        this.height = height;
    }
    private double width;
    private double height;

    public void area() {
        double areaSquare = 0.5 * height * width;
        System.out.println("The area of the square is " + areaSquare);
    };

    public void perimeter() {
        double perimeterSquare = height * width;
        System.out.println("The perimeter of the square is " + perimeterSquare);
    }
}
