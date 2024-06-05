package pl.coderslab.httpResponses;

import org.springframework.stereotype.Component;

@Component
public class ResponseMessage {
    public static final String BOOK_ADDED_SUCCESS_MESSAGE = "Book added successfully";
    public static final String BOOKS_RETRIEVED_SUCCESS_MESSAGE = "Book list retrieved successfully";
    public static final String BOOK_NOT_FOUND_MESSAGE = "Book with id %s not found";
    public static final String BOOK_RETRIEVED_SUCCESS_MESSAGE = "Book retrieved successfully";
    public static final String NOT_ENOUGH_DATA_TO_SAVE_BOOK_MESSAGE = "You did not provide enough data to save book";
    public static final String NOT_ENOUGH_DATA_TO_UPDATE_BOOK_MESSAGE = "You did not populate all fields to update book";
    public static final String BOOK_UPDATED_SUCCESS_MESSAGE = "Book updated successfully";
    public static final String BOOK_DELETED_SUCCESS_MESSAGE = "Book deleted successfully";
}
