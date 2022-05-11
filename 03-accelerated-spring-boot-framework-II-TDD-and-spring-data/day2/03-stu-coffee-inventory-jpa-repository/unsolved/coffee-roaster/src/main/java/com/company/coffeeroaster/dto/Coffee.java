package com.company.coffeeroaster.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "roaster")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer roasterId;

    private String name;
    private String type;

    public Coffee(Integer roasterId, String name, String type) {
        this.roasterId = roasterId;
        this.name = name;
        this.type = type;
    }

    public Coffee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(Integer roasterId) {
        this.roasterId = roasterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coffee coffee = (Coffee) o;
        return Objects.equals(id, coffee.id) && Objects.equals(roasterId, coffee.roasterId) && Objects.equals(name, coffee.name) && Objects.equals(type, coffee.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roasterId, name, type);
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "id=" + id +
                ", roasterId=" + roasterId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
