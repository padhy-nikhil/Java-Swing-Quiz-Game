package com.quizgame;

import com.quizgame.engine.GameEngine;
import com.quizgame.model.Question;

import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            List<Question> questionBank = new ArrayList<>();

            // 10 EASY JAVA QUESTIONS
            questionBank.add(new Question("Which component is responsible for running Java bytecode?", Arrays.asList("JDK", "JVM", "JRE", "Compiler"), 1, "Easy"));
            questionBank.add(new Question("What is the size of an int primitive type variable in Java?", Arrays.asList("1 byte", "2 bytes", "4 bytes", "8 bytes"), 2, "Easy"));
            questionBank.add(new Question("Which keyword is used to create an instance of a class in Java?", Arrays.asList("class", "new", "public", "void"), 1, "Easy"));
            questionBank.add(new Question("Which data type is used to store a single character in Java?", Arrays.asList("String", "char", "Character", "txt"), 1, "Easy"));
            questionBank.add(new Question("What is the starting index of an Array or ArrayList in Java?", Arrays.asList("-1", "0", "1", "It depends"), 1, "Easy"));
            questionBank.add(new Question("Which extension is used for compiled Java bytecode files?", Arrays.asList(".java", ".txt", ".class", ".exe"), 2, "Easy"));
            questionBank.add(new Question("Which of these is used to print text to the console in Java?", Arrays.asList("System.print()", "Console.log()", "System.out.println()", "print()"), 2, "Easy"));
            questionBank.add(new Question("Which of the following is NOT a primitive data type in Java?", Arrays.asList("int", "boolean", "String", "double"), 2, "Easy"));
            questionBank.add(new Question("How do you write a single-line comment in Java?", Arrays.asList("# comment", "// comment", "/* comment", "/ comment"), 1, "Easy"));
            questionBank.add(new Question("Which structural loop guarantees execution of its body at least once?", Arrays.asList("for loop", "while loop", "do-while loop", "foreach loop"), 2, "Easy"));

            // 10 MEDIUM JAVA QUESTIONS
            questionBank.add(new Question("Which of these is NOT a valid access modifier in Java?", Arrays.asList("public", "private", "protected", "internal"), 3, "Medium"));
            questionBank.add(new Question("What is the superclass of all classes in Java?", Arrays.asList("String", "Object", "Main", "Class"), 1, "Medium"));
            questionBank.add(new Question("Which keyword is used by a subclass to call a constructor of its parent class?", Arrays.asList("this", "parent", "super", "extends"), 2, "Medium"));
            questionBank.add(new Question("What type of inheritance does Java NOT support directly through classes?", Arrays.asList("Single Inheritance", "Multilevel Inheritance", "Multiple Inheritance", "Hierarchical Inheritance"), 2, "Medium"));
            questionBank.add(new Question("Which of these exceptions is a Checked Exception?", Arrays.asList("NullPointerException", "IOException", "ArrayIndexOutOfBoundsException", "ArithmeticException"), 1, "Medium"));
            questionBank.add(new Question("What does the 'final' keyword signify when applied to a class?", Arrays.asList("The class cannot be instantiated.", "The class cannot be subclassed/inherited.", "The class methods cannot be overloaded.", "The class is immutable."), 1, "Medium"));
            questionBank.add(new Question("Which collection class allows unique elements and maintains insertion order?", Arrays.asList("HashSet", "ArrayList", "LinkedHashSet", "TreeSet"), 2, "Medium"));
            questionBank.add(new Question("What is the purpose of the 'break' statement inside a switch block?", Arrays.asList("To terminate the entire program", "To skip the next case entry", "To exit the switch block immediately", "To clear the memory stack"), 2, "Medium"));
            questionBank.add(new Question("Which package is automatically imported into every Java program?", Arrays.asList("java.util", "java.io", "java.lang", "java.net"), 2, "Medium"));
            questionBank.add(new Question("What string comparison method checks for structural value equality instead of memory reference?", Arrays.asList("==", "equals()", "compare()", "compareTo()"), 1, "Medium"));

            // 10 HARD JAVA QUESTIONS
            questionBank.add(new Question("What is the default value of a local object reference variable in Java?", Arrays.asList("null", "0", "undefined", "Does not get initialized automatically"), 3, "Hard"));
            questionBank.add(new Question("Which memory area in Java is responsible for storing local variable references?", Arrays.asList("Heap Memory", "Stack Memory", "Method Area", "PermGen"), 1, "Hard"));
            questionBank.add(new Question("What happens during a Garbage Collection cycle on objects stored in the String Constant Pool?", Arrays.asList("They are never garbage collected.", "They are collected immediately when dereferenced.", "They are eligible for collection if no references exist anywhere.", "They move to the stack memory space."), 2, "Hard"));
            questionBank.add(new Question("Which mechanism allows a Java interface to contain concrete method implementations since Java 8?", Arrays.asList("Abstract methods", "Default methods", "Static initialization blocks", "Private native methods"), 1, "Hard"));
            questionBank.add(new Question("What state does a thread enter when it calls the object.wait() method inside a synchronized block?", Arrays.asList("BLOCKED", "RUNNABLE", "WAITING / TIMED_WAITING", "TERMINATED"), 2, "Hard"));
            questionBank.add(new Question("Which design layout is optimal to ensure thread-safety when implementing a Singleton Pattern in Java?", Arrays.asList("Lazy Initialization", "Eager Initialization", "Double-Checked Locking with volatile", "Static Block Initialization"), 2, "Hard"));
            questionBank.add(new Question("Which statement is true regarding Java's 'try-with-resources' statement?", Arrays.asList("It requires an explicit catch block.", "It can only close objects implementing AutoCloseable.", "It bypasses the finally block execution.", "It works only with file streams."), 1, "Hard"));
            questionBank.add(new Question("Which collection interface allows adding elements at both the beginning and end?", Arrays.asList("Set", "List", "Deque", "Map"), 2, "Hard"));
            questionBank.add(new Question("What is the default initial capacity and load factor of a HashMap in Java?", Arrays.asList("10 capacity, 0.5 load factor", "16 capacity, 0.75 load factor", "8 capacity, 0.75 load factor", "32 capacity, 0.5 load factor"), 1, "Hard"));
            questionBank.add(new Question("Which reference type in Java allows objects to be garbage collected aggressively if the JVM runs low on memory?", Arrays.asList("Strong Reference", "Soft Reference", "Weak Reference", "Phantom Reference"), 1, "Hard"));

            GameEngine game = new GameEngine(questionBank);
            game.start();
        });
    }
}