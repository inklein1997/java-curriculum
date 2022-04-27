package com.company.concreteapproach;

import static java.lang.Double.NaN;

public class Shape {

    private String name;
    private String color;
    private int xCoord;
    private int yCoord;

    public Shape(String name, String color, int xCoord, int yCoord) {
        this.name = name;
        this.color = color;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    public double area() {
        return NaN;
    }

    public double perimeter() {
        return NaN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getxCoord() {
        return xCoord;
    }

    public void setxCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public void setyCoord(int yCoord) {
        this.yCoord = yCoord;
    }
}
