package ua.training.gamingjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vlad on 29.10.16.
 */
public class NumberGuessingGame {

    protected final int EQUAL_NUMBERS_CODE = 0;
    protected final int NUMBER_IS_GREATER_CODE = 1;
    protected final int NUMBER_IS_LOWER_CODE = -1;
    protected final int NUMBER_IS_OUT_OF_RANGE_CODE = 2;

    protected int minNumber;
    protected int maxNumber;
    protected int proposedNumber;
    protected List<Integer> guesses;

    public NumberGuessingGame() {
    }

    public void initializeGame(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        guesses = new ArrayList<>();
        proposeNumber();
    }

    protected void proposeNumber() {
        Random random = new Random();
        proposedNumber = minNumber + random.nextInt(maxNumber - minNumber);
    }

    public int makeGuess(int guessedNumber) {
        if (guessedNumber < minNumber || guessedNumber > maxNumber) {
            return NUMBER_IS_OUT_OF_RANGE_CODE;
        }
        guesses.add(guessedNumber);
        if (guessedNumber > proposedNumber) {
            maxNumber = guessedNumber;
            return NUMBER_IS_GREATER_CODE;
        } else if (guessedNumber < proposedNumber) {
            minNumber = guessedNumber;
            return NUMBER_IS_LOWER_CODE;
        } else {
            return EQUAL_NUMBERS_CODE;
        }
    }

    public int[] getRange() {
        return new int[] { minNumber, maxNumber };
    }

    public List<Integer> getGuesses() {
        return guesses;
    }
}
