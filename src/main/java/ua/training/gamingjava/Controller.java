package ua.training.gamingjava;

import java.util.Scanner;

/**
 * Created by vlad on 29.10.16.
 */
public class Controller {

    private final int MIN_VALUE = 0;
    private final int MAX_VALUE = 100;

    private NumberGuessingGame game;
    private View view;
    private Scanner scanner;

    public Controller(NumberGuessingGame game, View view) {
        this.game = game;
        this.view = view;
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        game.initializeGame(MIN_VALUE, MAX_VALUE);

        view.printMessage(view.HELLO);
        boolean endGame = false;

        while (!endGame) {
            view.printMessageWithRange(view.GUESS_NUMBER_IN_RANGE, game.getRange());
            String userInput = readUserInput();
            if (checkUserInput(userInput)) {
                int usersNumber = Integer.parseInt(userInput);
                switch (game.makeGuess(usersNumber)) {
                    case -1:
                        view.printMessage(view.NUMBER_IS_LOWER);
                        break;
                    case 0:
                        view.printMessage(view.YOU_WIN);
                        view.printLastGuesses(game.getGuesses());
                        endGame = true;
                        break;
                    case 1:
                        view.printMessage(view.NUMBER_IS_GREATER);
                        break;
                    case 2:
                        view.printMessage(view.NUMBER_OUT_OF_RANGE);
                        break;
                }
            } else {
                view.printMessage(view.INCORRECT_INPUT);
            }
        }

    }

    public boolean checkUserInput(String userInput) {
        try {
            Integer.parseInt(userInput);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }

    public String readUserInput() {
        return scanner.nextLine();
    }
}
