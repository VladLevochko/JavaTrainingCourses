package ua.training.gamingjava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vlad on 29.10.16.
 */
public class Model {
    private int minNumber;
    private int maxNumber;
    private int proposedNumber;
    private List<String> attempts;

    public Model() {
    }

    /**
     * method set low and high limits of range,
     * initialize ArrayList where will be stored user attempts,
     * propose a number from range
     *
     * @param minNumber low limit of range
     * @param maxNumber high limit of range
     */
    public void initializeGame(int minNumber, int maxNumber) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        attempts = new ArrayList<>();
        proposeNumber();
    }

    /**
     * method set a random number from range to proposedNumber
     */
    public void proposeNumber() {
        Random random = new Random();
        proposedNumber = minNumber + random.nextInt(maxNumber - minNumber);
    }

    /**
     * method manually sets proposed number
     * @param proposedNumber number to set as proposed
     */
    public void setProposedNumber(int proposedNumber) {
        this.proposedNumber = proposedNumber;
    }

    /**
     * in method user's number compares to proposed number and returns status code of comparison
     * or exception if user enters not a number or this number is out of range
     * @param userInput string inputted by user
     * @return int status code of comparison
     * @throws NumberFormatException
     * @throws OutOfRangeException
     */
    public StatusCode guessNumber(String userInput) throws NumberFormatException, OutOfRangeException {
        attempts.add(userInput);

        //if userInput not number throw exception
        int userNumber = Integer.parseInt(userInput);

        //if number is out of range throw exception
        if (userNumber < minNumber || userNumber > maxNumber) {
            throw new OutOfRangeException();
        }

        if (userNumber == proposedNumber) {
            return StatusCode.NUMBERS_ARE_EQUAL;
        } else if (userNumber > proposedNumber) {
            maxNumber = userNumber;
            return StatusCode.NUMBER_IS_GREATER;
        } else {
            minNumber = userNumber;
            return StatusCode.NUMBER_IS_LOWER;
        }
    }

    /**
     * method return list of user attempts
     * @return list of attempts
     */
    public List<String> getAttempts() {
        return attempts;
    }

    public int[] getRange() {
        return new int[]{minNumber, maxNumber};
    }
}
