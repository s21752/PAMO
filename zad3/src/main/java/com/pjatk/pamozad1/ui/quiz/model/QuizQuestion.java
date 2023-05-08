package com.pjatk.pamozad1.ui.quiz.model;

import java.util.List;

public class QuizQuestion {

    List<QuizAnswer> answers;
    int correctAnswerId;
    String text;

    public List<QuizAnswer> getAnswers() {
        return answers;
    }

    public int getCorrectAnswerId() {
        return correctAnswerId;
    }

    public String getText() {
        return text;
    }

    public QuizQuestion(List<QuizAnswer> answers, int correctAnswerId, String text) {
        this.answers = answers;
        this.correctAnswerId = correctAnswerId;
        this.text = text;
    }
}
