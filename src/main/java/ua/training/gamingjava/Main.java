package ua.training.gamingjava;

import java.io.PrintWriter;

/**
 * Created by vlad on 29.10.16.
 */
public class Main {
    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        View view = new View(new PrintWriter(System.out));
        Controller controller = new Controller(game, view);
        controller.startGame();
    }
}