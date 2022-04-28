package com.company.abstractapproach;

public class Square extends Shape {
    public Square(String name, String color, int xCoord, int yCoord, double width) {
        super(name, color, xCoord, yCoord);
        this.width = width;
    }
    private double width;

    public void area() {
        double areaSquare = width * width;
        System.out.println("The area of the square is " + areaSquare);
    };

    public void perimeter() {
        double perimeterSquare = 4 * width;
        System.out.println("The perimeter of the square is " + perimeterSquare);
    }
}
