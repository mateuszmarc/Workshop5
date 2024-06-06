package pl.coderslab.httpResponses.customExceptions;

public class IncompleteRequestBodyException extends RuntimeException {
    public IncompleteRequestBodyException(String message) {
        super(message);
    }
}
