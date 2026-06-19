package com.quizgame.engine;

import com.quizgame.model.Question;
import com.quizgame.model.Quiz;
import com.quizgame.view.QuizWindow;

import javax.swing.Timer;
import java.util.ArrayList;
import java.util.List;

public class GameEngine {
    private List<Question> allQuestions;
    private List<Question> filteredQuestions;
    private Quiz quiz;
    private QuizWindow window;
    private int currentQuestionIndex;
    private String playerName;

    private Timer countdownTimer;
    private int timeLeft;
    private static final int TIME_LIMIT = 12;

    public GameEngine(List<Question> allQuestions) {
        this.allQuestions = allQuestions;
        this.filteredQuestions = new ArrayList<>();
        this.quiz = new Quiz();
        this.currentQuestionIndex = 0;
    }

    public void start() {
        window = new QuizWindow(this);

        while (true) {
            playerName = window.promptForName();
            if (playerName == null) {
                if (window.confirmExit()) {
                    System.exit(0);
                }
            } else {
                if (playerName.trim().isEmpty()) {
                    playerName = "Player";
                }
                break;
            }
        }

        String difficulty = window.promptForDifficulty();
        if (difficulty.equals("EXIT")) {
            System.exit(0);
        }

        filterQuestionsByDifficulty(difficulty);

        if (filteredQuestions.isEmpty()) {
            window.showErrorMessage("No questions available for this difficulty!");
            System.exit(0);
        }

        window.setupGameInterface(playerName);
        setupTimer();
        showNextQuestion();
    }

    private void filterQuestionsByDifficulty(String difficulty) {
        for (Question q : allQuestions) {
            if (q.getDifficulty().equalsIgnoreCase(difficulty)) {
                filteredQuestions.add(q);
                quiz.addQuestion(q);
            }
        }
    }

    private void setupTimer() {
        countdownTimer = new Timer(1000, e -> {
            timeLeft--;
            window.updateTimerDisplay(timeLeft);

            if (timeLeft <= 0) {
                countdownTimer.stop();

                boolean isLastQuestion = (currentQuestionIndex == filteredQuestions.size() - 1);

                if (isLastQuestion) {
                    window.showFinalTimeoutLayout();
                } else {
                    window.showAFKTimeoutLayout();
                }

                Timer skipDelay = new Timer(1500, delayEvent -> {
                    currentQuestionIndex++;
                    showNextQuestion();
                });
                skipDelay.setRepeats(false);
                skipDelay.start();
            }
        });
    }

    public void showNextQuestion() {
        if (currentQuestionIndex < filteredQuestions.size()) {
            Question question = filteredQuestions.get(currentQuestionIndex);

            window.displayQuestion(currentQuestionIndex + 1, filteredQuestions.size(), question);

            timeLeft = TIME_LIMIT;
            window.updateTimerDisplay(timeLeft);
            countdownTimer.restart();
        } else {
            countdownTimer.stop();
            window.displayFinalScore(playerName, quiz.getScore(), quiz.getTotalQuestions());
        }
    }

    public void handleAnswerSubmission(int selectedOptionIndex) {
        countdownTimer.stop();
        Question currentQuestion = filteredQuestions.get(currentQuestionIndex);

        if (currentQuestion.isCorrectAnswer(selectedOptionIndex + 1)) {
            quiz.incrementScore();
            window.showFeedback(true, "Correct! 🎉", currentQuestion.getCorrectAnswerText());
        } else {
            window.showFeedback(false, "Wrong! ❌", currentQuestion.getCorrectAnswerText());
        }

        currentQuestionIndex++;
        showNextQuestion();
    }

    public String getPlayerName() {
        return playerName;
    }
}