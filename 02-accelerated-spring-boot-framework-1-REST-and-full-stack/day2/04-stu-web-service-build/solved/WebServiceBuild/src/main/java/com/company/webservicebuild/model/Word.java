package com.company.webservicebuild.model;

import javax.validation.constraints.NotEmpty;

public class Word {

    private int id;
    @NotEmpty(message = "You must supply a word.")
    private String word;
    @NotEmpty(message = "You must supply a definition for the word.")
    private String definition;

    public Word() {

    }

    public Word(int id, String word, String definition) {
        this.id = id;
        this.word = word;
        this.definition = definition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
