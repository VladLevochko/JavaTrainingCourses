package ua.training.gamingjava;

/**
 * Created by vlad on 30.10.16.
 */

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestController {

    private static Controller controller;

    @BeforeClass
    public static void initialize() {
        controller = new Controller(new FakeGame(), new FakeView());
    }

    @Test
    public void testProcessCodeForWin() {
        boolean actualValue = controller.processStatusCode(StatusCode.NUMBERS_ARE_EQUAL);
        boolean expectedValue = true;

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testProcessCodeForNotWin() {
        boolean actualValue = controller.processStatusCode(StatusCode.NUMBER_IS_GREATER);
        boolean expectedValue = false;

        assertEquals(expectedValue, actualValue);
    }
}
