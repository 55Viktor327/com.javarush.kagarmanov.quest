package com.quest.model;

import java.util.Map;

public class Question {
    private int id;
    private String text;
    private Map<String, String> answers;

    public Question() {
    }

    public Question(int id, Map<String, String> answers, String text) {
        this.id = id;
        this.answers = answers;
        this.text = text;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
