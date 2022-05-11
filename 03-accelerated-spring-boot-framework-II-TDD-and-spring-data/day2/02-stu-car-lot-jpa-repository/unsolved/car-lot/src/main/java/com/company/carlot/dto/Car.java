package com.company.carlot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
    private String color;

    public Car() {
    }

    public Car(Integer id, String make, String color) {
        this.id = id;
        this.make = make;
        this.color = color;
    }

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
        return Objects.equals(id, car.id) && Objects.equals(make, car.make) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, make, color);
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", make='" + make + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
