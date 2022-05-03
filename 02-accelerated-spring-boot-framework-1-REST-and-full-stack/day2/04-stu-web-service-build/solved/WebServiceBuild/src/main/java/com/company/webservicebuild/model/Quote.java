package com.company.webservicebuild.model;

import javax.validation.constraints.NotEmpty;

public class Quote {

    private int id;
    @NotEmpty(message = "You must supply an author for the quote.")
    private String author;
    @NotEmpty(message = "You must supply a quote.")
    private String quote;

    public Quote() {

    }

    public Quote(int id, String author, String quote) {
        this.id = id;
        this.author = author;
        this.quote = quote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
