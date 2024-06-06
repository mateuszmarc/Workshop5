package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.httpResponses.BookGetAllBooksOkResponseStatusWrapper;
import pl.coderslab.httpResponses.BookOkResponseStatusWrapper;
import pl.coderslab.httpResponses.ResponseMessage;
import pl.coderslab.httpResponses.customExceptions.BookNotFoundException;
import pl.coderslab.httpResponses.customExceptions.IncompleteRequestBodyException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final MockBookService mockBookService;

    private static void throwIncompleteRequestBodyException() {
        throw new IncompleteRequestBodyException("Request body is missing values for book data fields");
    }

    private static void throwBookNotFoundException(long id) {
        throw new BookNotFoundException("Book with id:%s not found".formatted(id));
    }



    @RequestMapping("/helloBook")
    public ResponseEntity<BookOkResponseStatusWrapper> helloBook() {

        Book book =  new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        log.info("{}", book);

        return getBookStatusSuccessResponse(book, ResponseMessage.BOOK_ADDED_SUCCESS_MESSAGE);
    }

    private ResponseEntity<BookOkResponseStatusWrapper> getBookStatusSuccessResponse(Book book, String message) {
        BookOkResponseStatusWrapper bookOkResponseStatusWrapper = new BookOkResponseStatusWrapper(book, message);

        return ResponseEntity.status(HttpStatus.OK).body(bookOkResponseStatusWrapper);
    }


    @GetMapping
    public ResponseEntity<BookGetAllBooksOkResponseStatusWrapper> readAllBooks() {
        List<Book> books = mockBookService.getBooks();

        BookGetAllBooksOkResponseStatusWrapper bookGetAllBooksOkResponseStatusWrapper = new BookGetAllBooksOkResponseStatusWrapper(ResponseMessage.BOOKS_RETRIEVED_SUCCESS_MESSAGE, books);

        return ResponseEntity.ok(bookGetAllBooksOkResponseStatusWrapper);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookOkResponseStatusWrapper> findBookById(@PathVariable long id) {
        Optional<Book> optionalBook = mockBookService.get(id);

        if (optionalBook.isEmpty()) {
            throwBookNotFoundException(id);
        }

        return getBookStatusSuccessResponse(optionalBook.get(), ResponseMessage.BOOK_RETRIEVED_SUCCESS_MESSAGE);
    }


    @PostMapping
    public ResponseEntity<BookOkResponseStatusWrapper> addBook(@RequestBody Book book) {
        log.info("{}", book);

        if (doesBookToAddContainNullValues(book)) {
            throwIncompleteRequestBodyException();
        }

        mockBookService.add(book);
        return getBookStatusSuccessResponse(book, ResponseMessage.BOOK_ADDED_SUCCESS_MESSAGE);

    }


    private boolean doesBookToAddContainNullValues(Book book) {
        return book.getIsbn() == null
                || book.getAuthor() == null
                || book.getType() == null
                || book.getPublisher() == null
                || book.getTitle() == null;
    }


    @PutMapping
    public ResponseEntity<BookOkResponseStatusWrapper> updateBook(@RequestBody Book book) {
        Optional<Book> optionalBook = mockBookService.get(book.getId());

        if (doesBookToUpdateContainNullValues(book)) {
            throwIncompleteRequestBodyException();
        }

        if (optionalBook.isEmpty()) {
            throwBookNotFoundException(book.getId());
        }

        return getBookStatusSuccessResponse(book, ResponseMessage.BOOK_UPDATED_SUCCESS_MESSAGE);

    }


    private boolean doesBookToUpdateContainNullValues(Book book) {
        return book.getId() == null
                || book.getIsbn() == null
                || book.getAuthor() == null
                || book.getType() == null
                || book.getPublisher() == null
                || book.getTitle() == null;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<BookOkResponseStatusWrapper> deleteBook(@PathVariable long id) {
        Optional<Book> optionalBook = mockBookService.get(id);

        if (optionalBook.isEmpty()) {
            throwBookNotFoundException(id);
        }

        mockBookService.delete(id);
        return getBookStatusSuccessResponse(optionalBook.get(), ResponseMessage.BOOK_DELETED_SUCCESS_MESSAGE);
    }


}
