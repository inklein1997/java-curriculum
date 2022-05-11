package com.company.coffeeroaster.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "roaster")
public class Roaster {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "roasterId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Coffee> coffees;

    public Roaster(String name, Set<Coffee> coffees) {
        this.name = name;
        this.coffees = coffees;
    }

    public Roaster() {
    }

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
        return Objects.equals(id, roaster.id) && Objects.equals(name, roaster.name) && Objects.equals(coffees, roaster.coffees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coffees);
    }

    @Override
    public String toString() {
        return "Roaster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coffees=" + coffees +
                '}';
    }
}
