package com.company.simplecrmapi.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String content;
    private Integer customerId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Note)) return false;
        Note note = (Note) o;
        return Objects.equals(getId(), note.getId()) &&
                Objects.equals(getContent(), note.getContent()) &&
                Objects.equals(getCustomerId(), note.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getCustomerId());
    }
}
