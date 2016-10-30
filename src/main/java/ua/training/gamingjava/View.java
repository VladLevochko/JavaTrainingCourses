package ua.training.gamingjava;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by vlad on 29.10.16.
 */
public class View {

    public final String HELLO = "Hello! You are in game GuessNumber.\n";
    public final String GUESS_NUMBER_IN_RANGE = "Guess a number in range ";
    public final String NUMBER_OUT_OF_RANGE = "Try again! Number out of range\n";
    public final String NUMBER_IS_GREATER = "Your number is greater\n";
    public final String NUMBER_IS_LOWER = "Your number is lower\n";
    public final String YOU_WIN = "Well done! You guess!\n";
    public final String INCORRECT_INPUT = "It's incorrect number! Try again\n";
    public final String YOUR_GUESSES = "Your guesses: ";
    public final String ARROW = " -> ";

    private PrintWriter writer;

    public View(PrintWriter writer) {
        this.writer = writer;
    }

    public void printLastGuesses(List<Integer> guesses) {
        writer.print(YOUR_GUESSES);
        int numberOfGuesses = guesses.size();
        for (int i = 0; i < numberOfGuesses - 1; i++) {
            writer.print(guesses.get(i) + ARROW);
        }
        writer.println(guesses.get(numberOfGuesses - 1));
        writer.flush();
    }

    public void printMessage(String message) {
        writer.print(message);
        writer.flush();
    }

    public void printRange(int[] range) {
        writer.print("[" + range[0] + "; " + range[1] + "]");
        writer.flush();
    }

    public void printMessageWithRange(String message, int[] range) {
        printMessage(message);
        printRange(range);
        writer.println();
        writer.flush();
    }
}
