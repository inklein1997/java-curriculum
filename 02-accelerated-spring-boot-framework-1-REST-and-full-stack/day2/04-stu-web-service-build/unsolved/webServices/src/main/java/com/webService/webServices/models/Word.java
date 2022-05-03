package com.webService.webServices.models;

import java.util.Objects;

public class Word {
    private String word;
    private String definition;
    private int id;

    public Word(String word, String definition, int id) {
        this.word = word;
        this.definition = definition;
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
        Word word1 = (Word) o;
        return id == word1.id && Objects.equals(word, word1.word) && Objects.equals(definition, word1.definition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, definition, id);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", definition='" + definition + '\'' +
                ", id=" + id +
                '}';
    }
}
