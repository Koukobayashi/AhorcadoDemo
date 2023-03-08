package org.example;

public interface Game {
    void start();
    void play(String input);
    boolean isGameOver();

    String getSelectedWord();
}