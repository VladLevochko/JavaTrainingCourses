package ua.vlad.moreorless;

import java.io.PrintWriter;

/**
 * Created by vlad on 29.10.16.
 */
public class Main {
    public static void main(String[] args) {
        Model game = new Model();
        View view = new View(new PrintWriter(System.out));
        Controller controller = new Controller(game, view);

        controller.processUser();
    }
}
