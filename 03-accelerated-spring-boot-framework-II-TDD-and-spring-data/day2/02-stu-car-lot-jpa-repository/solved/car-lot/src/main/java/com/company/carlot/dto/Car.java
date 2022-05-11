package com.company.carlot.dto;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String make;
    private String model;
    private String year;
    private String color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId()) &&
                Objects.equals(getModel(), car.getModel()) &&
                Objects.equals(getMake(), car.getMake()) &&
                Objects.equals(getYear(), car.getYear()) &&
                Objects.equals(getColor(), car.getColor()) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getMake(), getYear() ,  getColor() );
    }
}
