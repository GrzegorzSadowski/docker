package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Buggy {

    private String name;
    private static List<String> messages = new ArrayList<>();

    public Buggy(String name) {
        this.name = name;
    }

    // BUG 1: Potential NullPointerException
    public void printNameInUpperCase() {
        // If name is null, this will throw a NullPointerException
        System.out.println(name.toUpperCase());
    }

    // BUG 2: Inefficient string concatenation inside a loop
    public String buildMessage(List<String> words) {
        String message = "";
        for (String word : words) {
            message += word + " "; // Inefficient, should use StringBuilder
        }
        return message.trim();
    }

    // BUG 3: Concurrency issue with non-thread-safe collection
    public void addMessage(String message) {
        // messages is a static shared resource and ArrayList is not thread-safe
        messages.add(message);
    }
}
