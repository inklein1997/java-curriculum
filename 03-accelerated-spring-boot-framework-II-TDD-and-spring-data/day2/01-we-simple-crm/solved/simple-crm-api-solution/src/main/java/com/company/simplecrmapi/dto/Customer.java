package com.company.simplecrmapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    private String company;
    private String phone;

    @OneToMany(mappedBy = "customerId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Note> notes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getId(), customer.getId()) &&
                Objects.equals(getFirstName(), customer.getFirstName()) &&
                Objects.equals(getLastName(), customer.getLastName()) &&
                Objects.equals(getCompany(), customer.getCompany()) &&
                Objects.equals(getPhone(), customer.getPhone()) &&
                Objects.equals(getNotes(), customer.getNotes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getCompany(), getPhone(), getNotes());
    }
}
