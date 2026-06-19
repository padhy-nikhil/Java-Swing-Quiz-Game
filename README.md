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


🚀 Getting Started
Prerequisites
Make sure you have Java Development Kit (JDK 8 or higher) installed on your machine. You can verify this by running java -version in your terminal.

💻 Installation & Execution (Using Terminal)
Clone the repository:

Bash
git clone https://github.com/YOUR_GITHUB_USERNAME/java-swing-quiz-game.git
cd java-swing-quiz-game
Compile all Java files: This command creates a bin directory and compiles all your packages into it:

Bash
javac -d bin src/com/quizgame/model/*.java src/com/quizgame/view/*.java src/com/quizgame/engine/*.java src/com/quizgame/Main.java
Run the application: Launch the game by pointing Java to your compiled Main class inside the classpath:

Bash
java -cp bin com.quizgame.Main
🛠️ Running in IntelliJ IDEA
If you prefer using an IDE instead of the terminal, follow these simple steps:

Open IntelliJ IDEA and click Open.

Navigate to your computer's folders and select the root QuizGame folder.

Once the project loads, expand the project view on the left. Right-click the src directory -> Mark Directory as -> Sources Root.

Navigate down to src/com/quizgame/Main.java.

Open Main.java and click the green Run triangle next to the public static void main method to start your quiz game instantly!
