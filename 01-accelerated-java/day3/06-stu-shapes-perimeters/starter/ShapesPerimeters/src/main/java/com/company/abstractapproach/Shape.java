package com.company.abstractapproach;

public abstract class Shape {
    public String name;
    public String color;
    public float xCoord;
    public float yCoord;

    public Shape(String name, String color, int xCoord, int yCoord) {
        this.name = name;
        this.color = color;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

//    public abstract void area();
//    public abstract void perimeter();

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

    public float getxCoord() {
        return xCoord;
    }

    public void setxCoord(float xCoord) {
        this.xCoord = xCoord;
    }

    public float getyCoord() {
        return yCoord;
    }

    public void setyCoord(float yCoord) {
        this.yCoord = yCoord;
    }
}
