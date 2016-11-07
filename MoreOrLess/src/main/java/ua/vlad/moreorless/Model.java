package ua.vlad.moreorless;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by vlad on 29.10.16.
 */
public class Model {
    /**
     * low limit of range
     */
    private int minBarrier;
    /**
     * high limit of range
     */
    private int maxBarrier;
    /**
     * number generated by a program, user may guess this number
     */
    private int secretNumber;
    /**
     * list of attempts of user
     */
    private List<Integer> attempts = new ArrayList<>();


    /**
     * method set primary low and high limits of range
     *
     * @param minBarrier integer value, low limit
     * @param maxBarrier integer value, high limit
     */
    public void setPrimaryBarrier(int minBarrier, int maxBarrier) {

        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    /**
     * Set a secret number.
     * Number generates randomly between minBarrier and maxBarrier (both exclusive)
     */
    public void setSecretNumber() {
        Random random = new Random();
        secretNumber = minBarrier + 1 + random.nextInt(maxBarrier - minBarrier - 1);
    }

    /**
     * Compare secret number with passed value and return true if they are equals
     * or false otherwise.
     * If value is greater than secret number, value sets to minBarrier.
     * If value is less than secret number, value sets to maxBarrier.
      * @param value value which compares with secretNumber
     * @return true if value equals to secretNumber or false otherwise
     */
    public boolean checkValue(int value) {
        attempts.add(value);

        if (secretNumber == value) {
            return true;
        } else if (secretNumber > value && minBarrier < value) {
            minBarrier = value;
        } else if (secretNumber < value && maxBarrier > value) {
            maxBarrier = value;
        }
        return false;
    }

    /**
     * Compare value with secret number.
     *
     * @param value
     * @return
     */
    public boolean checkValueIsGreater(int value) {
        return value > secretNumber;
    }

    /**
     *
     *
     * @param value
     * @return
     */
    public  boolean checkValueIsLower(int value) {
        return value < secretNumber;
    }

    public int getSecretNumber() {
        return this.secretNumber;
    }

    public List<Integer> getAttempts() {
        return attempts;
    }

    public int getMinBarrier() {
        return this.minBarrier;
    }

    public int getMaxBarrier() {
        return this.maxBarrier;
    }
}