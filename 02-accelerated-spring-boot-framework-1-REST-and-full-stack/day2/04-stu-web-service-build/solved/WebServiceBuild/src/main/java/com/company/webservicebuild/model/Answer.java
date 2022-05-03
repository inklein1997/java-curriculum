package com.company.webservicebuild.model;

import javax.validation.constraints.NotEmpty;

public class Answer {

    private int id;
    private String answer;

    @NotEmpty
    private String question;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
