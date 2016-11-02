package ua.training.gamingjava;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by vlad on 29.10.16.
 */
public class View {

    /**
     * messages
     */
    public final String HELLO = "Hello! You are in game GuessNumber.\n";
    public final String GUESS_NUMBER_IN_RANGE = "Guess a number in range ";
    public final String NUMBER_OUT_OF_RANGE = "Try again! Number out of range\n";
    public final String NUMBER_IS_GREATER = "This number is greater\n";
    public final String NUMBER_IS_LOWER = "This number is lower\n";
    public final String YOU_WIN = "Well done! You guess!\n";
    public final String INCORRECT_INPUT = "It's incorrect number! Try again\n";
    public final String YOUR_ATTEMPTS = "Your attempts: ";
    public final String ARROW = " -> ";

    private PrintWriter writer;

    public View(PrintWriter writer) {
        this.writer = writer;
    }

    /**
     * method print passed message
     * @param message string to print
     */
    public void printMessage(String message) {
        writer.print(message);
        writer.flush();
    }

    /**
     * method print passed message and range
     * @param message string to print
     * @param range current range
     */
    public void printMessageWithRange(String message, int[] range) {
        writer.print(message);
        writer.println("[" + range[0] + ", " + range[1] + "]");
        writer.flush();
    }

    /**
     * method print list of attempts of user
     * @param attempts list of user's attempts
     */
    public void printAttempts(List<Integer> attempts) {
        //if there are no attempts don't print anything
        if (attempts.size() == 0) {
            return;
        }
        writer.print(YOUR_ATTEMPTS);
        int numberOfAttempts = attempts.size();
        for (int i = 0; i < numberOfAttempts - 1; i++) {
            writer.print(attempts.get(i) + ARROW);
        }
        writer.println(attempts.get(numberOfAttempts - 1));
        writer.flush();
    }

}
