package com.company.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyIntializer", "handler"})
@Table(name="coffee")
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer roasterId;

    @NotNull
    private String name;
    @PositiveOrZero
    private Integer count;
    @PositiveOrZero
    private BigDecimal unitPrice;
    private String description;
    private String type;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return Objects.equals(getId(), coffee.getId()) &&
                Objects.equals(getRoasterId(), coffee.getRoasterId()) &&
                Objects.equals(getName(), coffee.getName()) &&
                Objects.equals(getCount(), coffee.getCount()) &&
                Objects.equals(getUnitPrice(), coffee.getUnitPrice()) &&
                Objects.equals(getDescription(), coffee.getDescription()) &&
                Objects.equals(getType(), coffee.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getRoasterId(), getName(), getCount(), getUnitPrice(), getDescription(), getType());
    }
}
