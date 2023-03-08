package org.example;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class HangmanGame implements Game {

    private List<String> words;
    private String selectedWord;
    private int maxTries;
    private int currentTry;
    private Set<Character> guessedLetters;

    public HangmanGame(List<String> words, int maxTries) {
        this.words = words;
        this.maxTries = maxTries;
        this.guessedLetters = new HashSet<>();
    }


    @Override
    public void start() {
        // Seleccionar una palabra aleatoria
        Random random = new Random();
        selectedWord = words.get(random.nextInt(words.size()));
        currentTry = 0;
        guessedLetters.clear();
    }

    @Override
    public boolean isGameOver() {
        return isLost() || isWon();
    }

    @Override
    public String getSelectedWord() {
        return null;
    }

    private boolean isLost() {
        return currentTry >= maxTries;
    }

    boolean isWon() {
        // Si todas las letras de la palabra están adivinadas, el jugador ha ganado.
        for (char letter : selectedWord.toCharArray()) {
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void play(String input) {
        // Añadir la letra adivinada al conjunto
        guessedLetters.add(input.charAt(0));

        // Si la letra no está en la palabra, aumentar el contador de intentos
        if (selectedWord.indexOf(input) < 0) {
            currentTry++;
        }
    }

    public String getCurrentState() {
        // Generar una cadena que muestre el estado actual del juego.
        StringBuilder state = new StringBuilder();
        for (char letter : selectedWord.toCharArray()) {
            if (guessedLetters.contains(letter)) {
                state.append(letter);
            } else {
                state.append("*");
            }
        }
        return state.toString();
    }

    public int getRemainingTries() {
        return maxTries - currentTry;
    }
}