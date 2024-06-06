package pl.coderslab.httpResponses.customExceptions;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomRequestExceptionHandler {

    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BookErrorResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "Invalid input: " + extractMessage(ex);
        BookErrorResponse errorResponse = new BookErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BookErrorResponse> handleHttpMessageNotReadableException(MethodArgumentTypeMismatchException ex) {
        String errorMessage = "Invalid path variable type: " + extractMessage(ex);
        BookErrorResponse errorResponse = new BookErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({BookNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<BookErrorResponse> handleBookNotFoundException(BookNotFoundException ex) {
        String errorMessage = extractMessage(ex);
        BookErrorResponse errorResponse = new BookErrorResponse(HttpStatus.NOT_FOUND.value(), errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({IncompleteRequestBodyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BookErrorResponse> handleIncompleteRequestBodyException(IncompleteRequestBodyException ex) {
        String errorMessage = extractMessage(ex);
        BookErrorResponse errorResponse = new BookErrorResponse(HttpStatus.BAD_REQUEST.value(), errorMessage);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    private String extractMessage(IncompleteRequestBodyException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            return "Cannot deserialize value: " + cause.getMessage();
        }
        return ex.getMessage();
    }

    private String extractMessage(HttpMessageNotReadableException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            return "Cannot deserialize value: " + cause.getMessage();
        }
        return ex.getMessage();
    }

    private String extractMessage(MethodArgumentTypeMismatchException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            return "Invalid path variable type: " + cause.getMessage();
        }
        return ex.getMessage();
    }

    private String extractMessage(BookNotFoundException ex) {
        Throwable cause = ex.getCause();
        if (cause instanceof InvalidFormatException) {
            return "No book found with given id: " + cause.getMessage();
        }
        return ex.getMessage();
    }
}
