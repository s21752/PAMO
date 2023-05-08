package com.pjatk.pamozad1.ui.quiz.model;

public class QuizAnswer {

    String text;
    int id;

    public String getText() {
        return text;
    }

    public int getId() {
        return id;
    }

    public QuizAnswer(String text, int id) {
        this.text = text;
        this.id = id;
    }
}
