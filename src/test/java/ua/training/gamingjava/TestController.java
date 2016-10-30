package ua.training.gamingjava;

/**
 * Created by vlad on 30.10.16.
 */

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestController {

    private final String CORRECT_INT_VALUE = "100";
    private final String INCORRECT_INT_VALUE = "100A";
    private final String EMPTY_STRING = "";
    private final String SINGLE_CHAR_STRING = "a";

//    private static NumberGuessingGame game;
//    private static View view;
    private static Controller controller;

    @BeforeClass
    public static void initialize() {
//        game = new NumberGuessingGame();
//        view = new View(null);
        controller = new Controller(null, null);
    }

    @Test
    public void testCheckUserInputWithCorrectValue() {
        assertTrue(controller.checkUserInput(CORRECT_INT_VALUE));
    }

    @Test
    public void testCheckUserInputWithIncorrectValue() {
        assertFalse(controller.checkUserInput(INCORRECT_INT_VALUE));
    }

    @Test
    public void testCheckUserInputWithEmptyString() {
        assertFalse(controller.checkUserInput(EMPTY_STRING));
    }

    @Test
    public void testCheckUserInputWithSingleChar() {
        assertFalse(controller.checkUserInput(SINGLE_CHAR_STRING));
    }
}
