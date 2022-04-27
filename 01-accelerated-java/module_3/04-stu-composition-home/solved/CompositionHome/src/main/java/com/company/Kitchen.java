package com.company;

public class Kitchen extends Room {
    private float counterSpace;
    private int numberOfBurners;

    public float getCounterSpace() {
        return counterSpace;
    }

    public int getNumberOfBurners() {
        return numberOfBurners;
    }

    public void setCounterSpace(float counterSpace) {
        this.counterSpace = counterSpace;
    }

    public void setNumberOfBurners(int numberOfBurners) {
        this.numberOfBurners = numberOfBurners;
    }
}
