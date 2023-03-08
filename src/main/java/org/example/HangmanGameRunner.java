package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class HangmanGameRunner {
    private static final List<String> WORDS = Arrays.asList("apple", "banana", "cherry", "date", "elderberry", "fig");
    private static final int MAX_TRIES = 6;

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame(WORDS, MAX_TRIES);
        game.start();
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            System.out.println("Current state: " + game.getCurrentState());
            System.out.println("Remaining tries: " + game.getRemainingTries());
            System.out.println(Drawing.draw(game.getRemainingTries())); // <-- Dibujar el ahorcado
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine();
            game.play(input);
        }

        if (game.isWon()) {
            System.out.println("Congratulations, you won! The word was " + game.getCurrentState() + ".");
        } else {
            System.out.println("Sorry, you lost. The word was " + game.getSelectedWord() + ".");
        }
    }
}