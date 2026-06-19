package com.quizgame.view;

import com.quizgame.engine.GameEngine;
import com.quizgame.model.Question;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class QuizWindow extends JFrame {
    private JLabel questionLabel;
    private JLabel nameLabel;  // UPDATED: Placed as a class-level variable
    private JLabel timerLabel;
    private List<JRadioButton> optionButtons;
    private ButtonGroup optionsGroup;
    private JButton submitButton;
    private GameEngine engine;

    private final Color COLOR_BG = new Color(33, 37, 41);
    private final Color COLOR_CARD = new Color(43, 48, 53);
    private final Color COLOR_TEXT = new Color(248, 249, 250);
    private final Color COLOR_ACCENT = new Color(13, 110, 253);
    private final Color COLOR_TIMER = new Color(220, 53, 69);
    private final Color COLOR_SUCCESS = new Color(40, 167, 69);

    public QuizWindow(GameEngine engine) {
        this.engine = engine;
        setTitle("Java Quiz Game");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        UIManager.put("OptionPane.background", COLOR_BG);
        UIManager.put("OptionPane.messageForeground", COLOR_TEXT);
        UIManager.put("Panel.background", COLOR_BG);
    }

    public boolean confirmExit() {
        int response = JOptionPane.showConfirmDialog(
                this, "Are you sure you want to exit the Quiz Game?",
                "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        return response == JOptionPane.YES_OPTION;
    }

    public String promptForName() {
        return JOptionPane.showInputDialog(this, "Welcome! Please enter your name:", "Quiz Registration", JOptionPane.QUESTION_MESSAGE);
    }

    public String promptForDifficulty() {
        String[] options = {"Easy", "Medium", "Hard"};
        while (true) {
            int choice = JOptionPane.showOptionDialog(this,
                    "Select your Game Difficulty level:", "Difficulty Selection",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);

            if (choice == JOptionPane.CLOSED_OPTION) {
                if (confirmExit()) return "EXIT";
            } else {
                if (choice == 1) return "Medium";
                if (choice == 2) return "Hard";
                return "Easy";
            }
        }
    }

    public void setupGameInterface(String playerName) {
        getContentPane().setBackground(COLOR_BG);
        setLayout(new GridBagLayout());
        GridBagConstraints mainGbc = new GridBagConstraints();
        mainGbc.gridx = 0;
        mainGbc.weightx = 1.0;
        mainGbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(COLOR_BG);
        topPanel.setBorder(new EmptyBorder(15, 25, 5, 25));

        nameLabel = new JLabel("PLAYER: " + playerName.toUpperCase());
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        nameLabel.setForeground(COLOR_ACCENT);

        timerLabel = new JLabel("TIME LEFT: 12s", SwingConstants.RIGHT);
        timerLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        timerLabel.setForeground(COLOR_TIMER);

        topPanel.add(nameLabel, BorderLayout.WEST);
        topPanel.add(timerLabel, BorderLayout.EAST);

        mainGbc.gridy = 0;
        add(topPanel, mainGbc);

        JPanel centerCard = new JPanel(new BorderLayout(10, 10)) {
            // This clever override stops the card from growing infinitely wide on full-screen
            @Override
            public Dimension getMaximumSize() {
                return new Dimension(650, 300);
            }
        };
        centerCard.setBackground(COLOR_CARD);
        centerCard.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 64, 67), 1),
                new EmptyBorder(20, 25, 20, 25)
        ));

        questionLabel = new JLabel("", SwingConstants.CENTER);
        questionLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        questionLabel.setForeground(COLOR_TEXT);
        centerCard.add(questionLabel, BorderLayout.NORTH);

        JPanel optionsPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        optionsPanel.setBackground(COLOR_CARD);

        optionButtons = new ArrayList<>();
        optionsGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            JRadioButton btn = new JRadioButton();
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            btn.setForeground(COLOR_TEXT);
            btn.setBackground(COLOR_CARD);
            btn.setFocusPainted(false);
            optionButtons.add(btn);
            optionsGroup.add(btn);
            optionsPanel.add(btn);
        }
        centerCard.add(optionsPanel, BorderLayout.CENTER);

        JPanel cardWrapper = new JPanel(new GridBagLayout());
        cardWrapper.setBackground(COLOR_BG);

        GridBagConstraints cardGbc = new GridBagConstraints();
        cardGbc.fill = GridBagConstraints.BOTH;
        cardGbc.weightx = 1.0;
        cardGbc.weighty = 1.0;
        cardGbc.insets = new Insets(0, 0, 0, 0);
        cardWrapper.add(centerCard, cardGbc);

        mainGbc.gridy = 1;
        mainGbc.weighty = 1.0;
        mainGbc.fill = GridBagConstraints.BOTH;
        mainGbc.insets = new Insets(10, 25, 10, 25);
        add(cardWrapper, mainGbc);

        submitButton = new JButton("SUBMIT ANSWER");
        submitButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        submitButton.setForeground(COLOR_TEXT);
        submitButton.setBackground(COLOR_ACCENT);
        submitButton.setFocusPainted(false);
        submitButton.setBorder(new EmptyBorder(12, 45, 12, 45));
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.addActionListener(e -> handleSubmitClick());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(COLOR_BG);
        bottomPanel.setBorder(new EmptyBorder(5, 25, 20, 25));
        bottomPanel.add(submitButton);

        GridBagConstraints bottomGbc = new GridBagConstraints();
        bottomGbc.gridx = 0;
        bottomGbc.gridy = 2;
        bottomGbc.weightx = 1.0;
        bottomGbc.fill = GridBagConstraints.HORIZONTAL;
        add(bottomPanel, bottomGbc);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                if (confirmExit()) System.exit(0);
            }
        });

        setVisible(true);
    }

    public void displayQuestion(int currentNum, int totalNum, Question question) {

        for (JRadioButton btn : optionButtons) {
            btn.setEnabled(true);
        }
        nameLabel.setText("PLAYER: " + engine.getPlayerName().toUpperCase() + "  |  QUESTION " + currentNum + " OF " + totalNum);

        questionLabel.setText("<html><center>" + question.getQuestionText() + "</center></html>");
        List<String> options = question.getOptions();
        optionsGroup.clearSelection();

        for (int i = 0; i < optionButtons.size(); i++) {
            if (i < options.size()) {
                optionButtons.get(i).setText("  " + options.get(i));
                optionButtons.get(i).setVisible(true);
            } else {
                optionButtons.get(i).setVisible(false);
            }
        }
    }

    public void updateTimerDisplay(int timeLeft) {
        timerLabel.setText("TIME LEFT: " + timeLeft + "s");
    }

    public void showTimeOutMessage() {
        JOptionPane.showMessageDialog(this, "⏰ Time's up! Moving to next question.", "Timeout", JOptionPane.WARNING_MESSAGE);
    }

    private void handleSubmitClick() {
        int selectedIndex = -1;
        for (int i = 0; i < optionButtons.size(); i++) {
            if (optionButtons.get(i).isSelected()) {
                selectedIndex = i;
                break;
            }
        }

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select an answer first!", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            engine.handleAnswerSubmission(selectedIndex);
        }
    }

    public void showFeedback(boolean isCorrect, String title, String correctAnswer) {
        String message = isCorrect ? "Awesome job!" : "Correct Answer:\n➡️ " + correctAnswer;
        JOptionPane.showMessageDialog(this, message, title, isCorrect ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
    }

    public void showErrorMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayFinalScore(String name, int score, int total) {
        this.dispose(); // Close active quiz window

        JFrame endFrame = new JFrame("Quiz Results");
        endFrame.setSize(550, 420);
        endFrame.setLocationRelativeTo(null);
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.getContentPane().setBackground(COLOR_BG);
        endFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        double percentage = ((double) score / total) * 100;
        String reactionTitle;
        String reactionMessage;
        Color scoreColor;

        if (percentage == 100) {
            reactionTitle = "🏆 PERFECT SCORE! 🏆";
            reactionMessage = "Unbelievable! You are a certified Java Master!";
            scoreColor = new Color(255, 193, 7); // Gold Accent
        } else if (percentage >= 80) {
            reactionTitle = "🔥 OUTSTANDING! 🔥";
            reactionMessage = "Incredible job, " + name + "! You really know your stuff.";
            scoreColor = COLOR_SUCCESS; // Clean Green
        } else if (percentage >= 50) {
            reactionTitle = "👍 GOOD JOB! 👍";
            reactionMessage = "Solid effort! A little more practice and you'll be an expert.";
            scoreColor = COLOR_ACCENT; // Sleek Blue
        } else if (score > 0) {
            reactionTitle = "📚 KEEP LEARNING! 📚";
            reactionMessage = "Nice try, but there's room for improvement. Review the basics!";
            scoreColor = new Color(253, 126, 20); // Warning Orange
        } else {
            reactionTitle = "💀 OUCH! 💀";
            reactionMessage = "Did you go completely AFK? Time to hit the books from scratch!";
            scoreColor = COLOR_TIMER; // Coral Red
        }

        JLabel completedLabel = new JLabel("COMPLETED", SwingConstants.CENTER);
        completedLabel.setFont(new Font("Impact", Font.PLAIN, 52));
        completedLabel.setForeground(COLOR_SUCCESS);
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 5, 0);
        endFrame.add(completedLabel, gbc);

        JLabel reactionTitleLabel = new JLabel(reactionTitle, SwingConstants.CENTER);
        reactionTitleLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        reactionTitleLabel.setForeground(scoreColor);
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0);
        endFrame.add(reactionTitleLabel, gbc);

        JLabel marksLabel = new JLabel("SCORE: " + score + " / " + total, SwingConstants.CENTER);
        marksLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        marksLabel.setForeground(COLOR_TEXT);
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 15, 0);
        endFrame.add(marksLabel, gbc);

        JLabel feedbackLabel = new JLabel("<html><center>" + reactionMessage + "</center></html>", SwingConstants.CENTER);
        feedbackLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        feedbackLabel.setForeground(new Color(173, 181, 189)); // Subdued light gray
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 30, 35, 30); // Extra padding on sides for text wrapping
        endFrame.add(feedbackLabel, gbc);

        JButton exitButton = new JButton("CLOSE GAME");
        exitButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
        exitButton.setForeground(COLOR_TEXT);
        exitButton.setBackground(new Color(108, 117, 125));
        exitButton.setFocusPainted(false);
        exitButton.setBorder(new EmptyBorder(10, 35, 10, 35));
        exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        exitButton.addActionListener(e -> System.exit(0));
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 10, 0);
        endFrame.add(exitButton, gbc);

        endFrame.setVisible(true);
    }


        public void showAFKTimeoutLayout() {
            optionsGroup.clearSelection();

            questionLabel.setText("<html><center><font color='#DC3545'>⏰ TIME'S UP!<br>Moving to the next question...</font></center></html>");

            for (JRadioButton btn : optionButtons) {
                btn.setEnabled(false);
            }
        }

    public void showFinalTimeoutLayout() {
        optionsGroup.clearSelection();
        questionLabel.setText("<html><center><font color='#DC3545'>⏰ TIME'S UP!<br>Calculating your final score...</font></center></html>");

        for (JRadioButton btn : optionButtons) {
            btn.setEnabled(false);
        }
    }
}
