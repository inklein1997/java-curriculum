package com.example.customerdataservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long customerId;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String zipcode;
    private String level;

    public Customer(){}

    public Customer(String firstName, String lastName, String street, String city, String state, String zipcode,
            String level) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.level = level;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

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

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getCustomerId(), customer.getCustomerId()) && Objects.equals(getFirstName(), customer.getFirstName()) && Objects.equals(getLastName(), customer.getLastName()) && Objects.equals(getStreet(), customer.getStreet()) && Objects.equals(getCity(), customer.getCity()) && Objects.equals(getState(), customer.getState()) && Objects.equals(getZipcode(), customer.getZipcode()) && Objects.equals(getLevel(), customer.getLevel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getFirstName(), getLastName(), getStreet(), getCity(), getState(), getZipcode(), getLevel());
    }
}
