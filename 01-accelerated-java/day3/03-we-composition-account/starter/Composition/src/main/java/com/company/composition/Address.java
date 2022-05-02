package com.company.composition;

public class Address {

//    public Address(String street, String city, String state, int zipcode) {
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.zipcode = zipcode;
//    }
//
//    public Address() {};


    public Address(String street, String city, String state, int zipcode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public Address() {}

    private String street;
    private String city;
    private String state;
    private int zipcode;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\n' +
                ", city='" + city + '\n' +
                ", state='" + state + '\n' +
                ", zipcode=" + zipcode +
                '}';
    }
}