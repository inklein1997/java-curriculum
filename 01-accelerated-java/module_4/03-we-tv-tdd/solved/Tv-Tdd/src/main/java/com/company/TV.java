package com.company;

public class TV {
    private int channel;
    private boolean isOn = false;

    public TV(int channel){
        this.channel = channel;
    }

    public void on() {
        isOn = true;
    }

    public void off() {
        isOn = false;
    }

    public boolean isOn(){
        return isOn;
    }

    public void increaseChannel() {
        channel++;
    }

    public int getChannel() {
        return channel;
    }
}
