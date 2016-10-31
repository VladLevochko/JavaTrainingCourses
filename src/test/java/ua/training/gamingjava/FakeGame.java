package ua.training.gamingjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vlad on 31.10.16.
 */
public class FakeGame extends Model {

    public FakeGame() {

    }

    public void initializeGame(int minNumber, int maxNumber) {
    }

    public void proposeNumber() {
    }

    public void setProposedNumber(int proposedNumber) {
    }

    public StatusCode guessNumber(String userInput) throws NumberFormatException, OutOfRangeException {
        return null;
    }

    public List<String> getAttempts() {
        return null;
    }

    public int[] getRange() {
        return new int[0];
    }
}
