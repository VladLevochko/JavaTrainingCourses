package ua.vlad.moreorless;

import java.io.PrintWriter;
import java.util.List;

/**
 * Created by vlad on 29.10.16.
 */
public class View {

    /**
     * messages
     */
    public final String HELLO = "Hello! You are in game GuessNumber.";
    public final String INPUT_RANGE_LIMITS = "Input low and high limits for range";
    public final String INCORRECT_RANGE_LIMITS = "Incorrect range limits! Try again";
    public final String GUESS_NUMBER_IN_RANGE = "Guess a number in range ";
    public final String NUMBER_OUT_OF_RANGE = "Try again! Number out of range";
    public final String NUMBER_IS_GREATER = "This number is greater";
    public final String NUMBER_IS_LOWER = "This number is lower";
    public final String YOU_WIN = "Well done! You guess!";
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
        writer.println(message);
        writer.flush();
    }

    public void printRange(int minBarrier, int maxBarrier) {
        writer.println("[" + minBarrier + ", " + maxBarrier + "]");
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
