package com.quizgame.model;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    private List<Question> questions;
    private int score;

    public Quiz() {
        this.questions = new ArrayList<>();
        this.score = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }
    public List<Question> getQuestions() {
        return questions;
    }
    public int getScore() {
        return score;
    }
    public void incrementScore() {
        this.score++;
    }
    public int getTotalQuestions() {
        return questions.size();
    }
}