package com.company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
@Table(name="roaster")
public class Roaster {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String street;
    @NotNull
    private String city;
    @NotNull
    @Size(min=2, max=2, message="You must use the 2 letter state code")
    private String state;
    @NotNull
    private String postalCode;
    @NotNull
    private String phone;
    @NotNull
    @Email
    private String email;
    @NotNull
    private String note;

    @OneToMany(mappedBy="roasterId", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private Set<Coffee> coffees;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Coffee> getCoffees() {
        return coffees;
    }

    public void setCoffees(Set<Coffee> coffees) {
        this.coffees = coffees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return Objects.equals(getId(), roaster.getId()) &&
                Objects.equals(getName(), roaster.getName()) &&
                Objects.equals(getStreet(), roaster.getStreet()) &&
                Objects.equals(getCity(), roaster.getCity()) &&
                Objects.equals(getState(), roaster.getState()) &&
                Objects.equals(getPostalCode(), roaster.getPostalCode()) &&
                Objects.equals(getPhone(), roaster.getPhone()) &&
                Objects.equals(getEmail(), roaster.getEmail()) &&
                Objects.equals(getNote(), roaster.getNote()) &&
                Objects.equals(getCoffees(), roaster.getCoffees());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail(), getNote(), getCoffees());
    }
}
