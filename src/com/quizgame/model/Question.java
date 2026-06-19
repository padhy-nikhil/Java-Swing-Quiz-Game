package com.quizgame.model;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> options;
    private int correctOptionIndex; // 0-based index internally
    private String difficulty; 

    public Question(String questionText, List<String> options, int correctOptionIndex, String difficulty) {
        this.questionText = questionText;
        this.options = options;
        this.correctOptionIndex = correctOptionIndex;
        this.difficulty = difficulty;
    }

    public String getQuestionText() {
        return questionText;
    }
    public List<String> getOptions() {
        return options;
    }
    public boolean isCorrectAnswer(int userChoice) {
        return userChoice - 1 == correctOptionIndex;
    }
    public String getCorrectAnswerText() {
        return options.get(correctOptionIndex);
    }
    public String getDifficulty() {
        return difficulty;
    }
}