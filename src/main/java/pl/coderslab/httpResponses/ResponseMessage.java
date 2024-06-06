package pl.coderslab.httpResponses;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessage {
    public static final String BOOK_ADDED_SUCCESS_MESSAGE = "Book added successfully";
    public static final String BOOKS_RETRIEVED_SUCCESS_MESSAGE = "Book list retrieved successfully";
    public static final String BOOK_RETRIEVED_SUCCESS_MESSAGE = "Book retrieved successfully";
    public static final String BOOK_UPDATED_SUCCESS_MESSAGE = "Book updated successfully";
    public static final String BOOK_DELETED_SUCCESS_MESSAGE = "Book deleted successfully";
}
