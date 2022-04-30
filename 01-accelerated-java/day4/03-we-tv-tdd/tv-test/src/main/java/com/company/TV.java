package com.company;

public class TV {
    public TV(int channel) {
        this.channel = channel;
    }

    private boolean on;
    private int channel;

    //behavior
    public boolean isOn() {
        return on;
    }

    public void turnOn() {
        this.on = true;
    }

    public void turnOff() {
        this.on = false;
    }

    public void increaseChannel() {
        this.channel++;
    }

    // getters and setters
    public int getChannel() {
        return channel;
    }
}
