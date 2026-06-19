# Java-Swing-Quiz-Game
# 🏆 Modern Java Swing Quiz Game

A sleek, responsive, and fully automated **Java Swing** desktop application designed with a modern dark-mode aesthetic. This project tests core Java knowledge across multiple difficulty tiers while implementing advanced concurrent thread handling, real-time timer countdowns, and dynamic visual layouts.

---

## ✨ Features

* **Custom Dark Theme:** Modern look and feel utilizing a flat, high-contrast dark palette tailored for developer comfort.
* **Dynamic Difficulty Selection:** Filters and builds unique question decks dynamically based on user choice (**Easy**, **Medium**, **Hard**).
* **Live 12-Second Countdown:** Driven by a concurrent Swing background timer thread that tracks time per question.
* **Automated AFK/Timeout Loop:** Non-blocking handling for idle users. If the timer hits zero, the UI smoothly transitions, displays an automated warning, and advances automatically without freezing.
* **Fully Responsive Layout:** Built using custom nested `GridBagLayout` override configurations to look clean on compact default window states or full-screen displays without stretching.
* **Performance Metrics:** Displays an end-game score report with custom, color-coded badges and personalized feedback statements depending on the final percentage achieved.

---

## 📂 Project Architecture

The codebase follows a modular design pattern, strictly separating data models, UI layers, and runtime logical components:

```text
QuizGame/
└── src/
    └── com/
        └── quizgame/
            ├── Main.java          # Application Entry Point & Question Dataset Pool
            ├── model/
            │   ├── Question.java  # Blueprint for individual question structures
            │   └── Quiz.java      # State tracker for core quiz data and scoring
            ├── engine/
            │   └── GameEngine.java # Main Controller managing core game loops and timing
            └── view/
                └── QuizWindow.java # GUI View layout rendering all Swing elements
🛠️ Technology Stack & Concepts Used
Language: Java (JDK 8+)

GUI Framework: Java Swing & AWT

Concurrency: javax.swing.Timer for asynchronous event dispatch looping.

Layout Managers: GridBagLayout, BorderLayout, and GridLayout for fully responsive scaling profiles.

🚀 Getting Started
Prerequisites
Make sure you have Java Development Kit (JDK 8 or higher) installed on your machine.

Installation & Execution (Terminal)
Clone the repository:

Bash
git clone [https://github.com/YOUR_GITHUB_USERNAME/java-swing-quiz-game.git](https://github.com/YOUR_GITHUB_USERNAME/java-swing-quiz-game.git)
cd java-swing-quiz-game
Compile the packages:

Bash
javac -d bin src/com/quizgame/model/*.java src/com/quizgame/view/*.java src/com/quizgame/engine/*.java src/com/quizgame/Main.java
Run the application:

Bash
java -cp bin com.quizgame.Main
Running in IntelliJ IDEA
Open IntelliJ IDEA and select Open.

Navigate to and choose the root QuizGame folder.

Right-click the src directory in the Project view panel -> Mark Directory as -> Sources Root.

Open src/com/quizgame/Main.java and click the green Run triangle!

🏢 About This Project
