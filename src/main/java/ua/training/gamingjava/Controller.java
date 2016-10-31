package ua.training.gamingjava;

import java.util.Scanner;

/**
 * Created by vlad on 29.10.16.
 */
public class Controller {

    /**
     * constant range limits
     */
    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 100;

    private Model model;
    private View view;
    private Scanner scanner;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    /**
     * method initialize model and set limits of range
     * in loop read user's value, pass it to guessNumber() and check status code
     */
    public void startGame() {
        model.initializeGame(MIN_VALUE, MAX_VALUE);

        view.printMessage(view.HELLO);

        boolean userWin = false;
        while (!userWin) {
            try {
                view.printAttempts(model.getAttempts());
                view.printMessageWithRange(view.GUESS_NUMBER_IN_RANGE, model.getRange());

                String userInput = readUserInput();
                StatusCode statusCode = model.guessNumber(userInput);
                userWin = processStatusCode(statusCode);
            } catch (NumberFormatException e) {
                view.printMessage(view.INCORRECT_INPUT);
            } catch (OutOfRangeException e) {
                view.printMessage(view.NUMBER_OUT_OF_RANGE);
            }
        }

    }

    /**
     * method checks status code and prints appropriate message
     * if user win (status code equal NUMBERS_ARE_EQUALS) returns true, otherwise - false
     * @param statusCode
     * @return true if user guess number, otherwise false
     */
    public boolean processStatusCode(StatusCode statusCode) {
        boolean userWin = false;
        switch (statusCode) {
            case NUMBERS_ARE_EQUAL:
                userWin = true;
                view.printMessage(view.YOU_WIN);
                break;
            case NUMBER_IS_GREATER:
                view.printMessage(view.NUMBER_IS_GREATER);
                break;
            case NUMBER_IS_LOWER:
                view.printMessage(view.NUMBER_IS_LOWER);
                break;
        }

        return userWin;
    }

    /**
     * read string using scanner
     * @return read string
     */
    public String readUserInput() {
        return scanner.nextLine();
    }
}
