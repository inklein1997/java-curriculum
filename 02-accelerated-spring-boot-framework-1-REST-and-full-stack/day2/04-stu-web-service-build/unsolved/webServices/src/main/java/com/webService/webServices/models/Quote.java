package com.webService.webServices.models;

import com.webService.webServices.controllers.QuoteController;

import java.util.Objects;

public class Quote {
    private String author;
    private String quote;
    private int id;

    public Quote(String author, String quote, int id) {
        this.author = author;
        this.quote = quote;
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote1 = (Quote) o;
        return id == quote1.id && Objects.equals(author, quote1.author) && Objects.equals(quote, quote1.quote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, quote, id);
    }

    @Override
    public String toString() {
        return "Quote{" +
                "author='" + author + '\'' +
                ", quote='" + quote + '\'' +
                ", id=" + id +
                '}';
    }
}
