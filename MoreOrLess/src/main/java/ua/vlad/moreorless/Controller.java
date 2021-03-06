package ua.vlad.moreorless;

import java.util.Scanner;

/**
 * Created by vlad on 29.10.16.
 */
public class Controller {

    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Creates new instance of Scanner to read from standard input.
     * Initialize model with values. Sets barriers and call method setSecretNumber
     * to generate and set secret number.
     * Prints greeting.
     * Read values from user and process them.
     * If user win, prints appropriate message.
     */
    public void processUser() {
        scanner = new Scanner(System.in);

        view.printMessage(view.HELLO);

        inputBarrier();

        model.setSecretNumber();

        int inputValue;
        do {
            inputValue = inputNumber();
        } while (!processValue(inputValue));

        view.printMessage(view.YOU_WIN);
    }

    /**
     * Read values of range limits. If difference between maxBarrier and
     * minBarrier lower or equal 1, prints error message and ask user to
     * write limits again.
     */
    private void inputBarrier() {
        view.printMessage(view.INPUT_RANGE_LIMITS);
        int minBarrier = inputValueWithScanner();
        int maxBarrier = inputValueWithScanner();

        while (maxBarrier - minBarrier <= 1) {
            view.printMessage(view.INCORRECT_RANGE_LIMITS);
            view.printMessage(view.INPUT_RANGE_LIMITS);
            minBarrier = inputValueWithScanner();
            maxBarrier = inputValueWithScanner();
        }

        model.setPrimaryBarrier(minBarrier, maxBarrier);
    }

    /**
     *  Check inputValue does it in allowed range and equals to secret number.
     *  If inputValue not in range or not equal to secret number returns false.
     *  Otherwise returns true.
     *
     * @param inputValue value to check
     * @return true if value in range and equal to secret number
     */
    public boolean processValue(int inputValue) {
        return checkValueInRange(inputValue) && model.checkValue(inputValue);
    }

    /**
     * Checks if inputValue is in allowed range.
     * If inputValue out of range prints appropriate message ant false returns.
     * If inputValue in range, it checks for more or less than secret number
     * calling checkMoreOrLess method and returns true.
     *
     * @param inputValue value to check
     * @return true if inputValue in allowed range and false otherwise
     */
    public boolean checkValueInRange(int inputValue) {
        if (inputValue <= model.getMinBarrier()
                || inputValue >= model.getMaxBarrier()) {
            view.printMessage(view.NUMBER_OUT_OF_RANGE);

            return false;
        }
        checkMoreOrLess(inputValue);

        return true;
    }

    /**
     * Checks does inputValue greater of lower than secret value
     * and prints appropriate value
     *
     * @param inputValue value to check with secret number
     */
    private void checkMoreOrLess(int inputValue) {
        if (model.checkValueIsGreater(inputValue)) {
            view.printMessage(view.NUMBER_IS_GREATER);
        } else if (model.checkValueIsLower(inputValue)) {
            view.printMessage(view.NUMBER_IS_LOWER);
        }
    }

    public int inputNumber() {
        view.printAttempts(model.getAttempts());
        view.printMessage(view.GUESS_NUMBER_IN_RANGE);
        view.printRange(model.getMinBarrier(), model.getMaxBarrier());

        return inputValueWithScanner();
    }

    /**
     * Prints information about allowed range.
     * Ignores all non integer values entered by user.
     * Return integer value entered by user.
     *
     * @return entered integer value
     */
    public int inputValueWithScanner() {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }

        return scanner.nextInt();
    }
}
