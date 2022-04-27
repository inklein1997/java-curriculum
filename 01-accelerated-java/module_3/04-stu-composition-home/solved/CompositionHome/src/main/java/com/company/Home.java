package com.company;

public class Home {
    private String street;
    private String city;
    private String state;
    private String zip;
    private Basement basement;
    private Bathroom bathroom;
    private Bedroom bedroom;
    private Kitchen kitchen;
    private Patio patio;


    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public Basement getBasement() {
        return basement;
    }

    public Bathroom getBathroom() {
        return bathroom;
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public Kitchen getKitchen() {
        return kitchen;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setBasement(Basement basement) {
        this.basement = basement;
    }

    public void setBathroom(Bathroom bathroom) {
        this.bathroom = bathroom;
    }

    public void setBedroom(Bedroom bedroom) {
        this.bedroom = bedroom;
    }

    public void setKitchen(Kitchen kitchen) {
        this.kitchen = kitchen;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }
}
