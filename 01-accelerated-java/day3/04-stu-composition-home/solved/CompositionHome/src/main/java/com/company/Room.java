package com.company;

public class Room {
    private float length;
    private float width;
    private float ceilingHeight;
    private String flooringType;

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public float getCeilingHeight() {
        return ceilingHeight;
    }

    public String getFlooringType() {
        return flooringType;
    }

    public float getSquareFootage() {
        return length * width;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setCeilingHeight(float ceilingHeight) {
        this.ceilingHeight = ceilingHeight;
    }

    public void setFlooringType(String flooringType) {
        this.flooringType = flooringType;
    }
}
