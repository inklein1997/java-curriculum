package com.company.concreteapproach;

public class App {
    public static void main(String[] args) {
        Circle circle = new Circle("Circle", "Blue", 5, 5, 1.25);
        Square square = new Square("Square", "Red", 1, 1, 23);
        Triangle triangle = new Triangle("Triangle", "Yellow", 10, 10, 10, 12);

        circle.area();
        circle.perimeter();
        triangle.area();
        triangle.perimeter();
        square.area();
        square.perimeter();
    }

}
