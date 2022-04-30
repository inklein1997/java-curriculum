package com.company;

public class Patio {
    private float length;
    private float width;
    private boolean enclosed;

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
    }

    public boolean isEnclosed() {
        return enclosed;
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

    public void setEnclosed(boolean enclosed) {
        this.enclosed = enclosed;
    }
}
