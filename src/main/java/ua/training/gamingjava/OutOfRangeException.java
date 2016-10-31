package ua.training.gamingjava;

/**
 * Created by vlad on 31.10.16.
 */
public class OutOfRangeException extends Exception {

    private static final String DEFAULT_MESSAGE = "Value is out of allowed range";

    public OutOfRangeException() {
        super(DEFAULT_MESSAGE);
    }

    public OutOfRangeException(String message) {
        super(message);
    }
}
