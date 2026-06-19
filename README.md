# QuizGame

A desktop quiz application built with Java Swing as part of an internship project at **Pinnacle Labs**.

---

## Internship Details

| Field | Details |
|---|---|
| Organization | Pinnacle Labs |
| Project | QuizGame — Java Desktop Application |
| Technology | Java 16+, Swing |

---

## Overview

QuizGame is a single-file, dependency-free desktop application that presents users with multiple-choice questions, tracks their score, and displays results at the end of each session. The application is built entirely with Java's built-in Swing library — no external dependencies required.

---

## Project Structure

```
QuizGame/
├── src/
│   └── com/quizgame/
│       ├── engine/
│       │   └── GameEngine.java       # Core game logic and state management
│       ├── model/
│       │   ├── Question.java         # Question data model (text + options + answer)
│       │   └── Quiz.java             # Quiz container (holds list of Questions)
│       ├── view/
│       │   └── (UI components)       # Swing panels and windows
│       └── Main.java                 # Entry point — launches the application
├── bin/                              # Compiled .class files
├── out/                              # Build output directory
├── .gitignore
└── QuizGame.iml                      # IntelliJ IDEA module file
```

---

## Architecture

The project follows a clean separation of concerns across three layers.

**Model** (`com.quizgame.model`)
Holds the data. `Question` represents a single quiz item — the question text, answer choices, and the correct answer. `Quiz` is a collection of `Question` objects that makes up one full game session.

**Engine** (`com.quizgame.engine`)
`GameEngine` drives the game. It tracks the current question index, validates answers, updates the score, and signals when the quiz is complete.

**View** (`com.quizgame.view`)
Swing-based UI components. These listen to the engine and update the display — question text, answer buttons, score counter, and the results screen.

**Entry Point** (`Main.java`)
Bootstraps the application, wires the engine to the view, and starts the Swing event dispatch thread.

---

## Requirements

- Java 16 or higher
- No external libraries or build tools required

---

## Build and Run

**Compile**

```bash
javac -d out src/com/quizgame/model/*.java \
             src/com/quizgame/engine/*.java \
             src/com/quizgame/view/*.java \
             src/Main.java
```

**Run**

```bash
java -cp out Main
```

Or from IntelliJ IDEA, right-click `Main.java` and select **Run 'Main'**.

---

## Features

- Multiple-choice question format
- Score tracking across the session
- Results summary at the end of the quiz
- Lightweight — runs on any machine with Java installed
- No internet connection or external dependencies needed

---

## How It Works

1. `Main.java` starts the app and initializes `GameEngine` with a `Quiz`.
2. The `GameEngine` serves questions one at a time to the `view` layer.
3. The user selects an answer; the engine checks it and updates the score.
4. Once all questions are answered, the results screen is shown.

---

## Author

Developed by **Nikhil** during an internship at **Pinnacle Labs**.
