package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.httpResponses.BookGetAllBooksSuccessWrapper;
import pl.coderslab.httpResponses.BookResponseStatusWrapper;
import pl.coderslab.httpResponses.ResponseMessage;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final MockBookService mockBookService;

    @RequestMapping("/helloBook")
    public ResponseEntity<BookResponseStatusWrapper> helloBook() {

        Book book =  new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        log.info("{}", book);

        return getBookStatusSuccessResponse(book, ResponseMessage.BOOK_ADDED_SUCCESS_MESSAGE);
    }


    @GetMapping
    public ResponseEntity<BookGetAllBooksSuccessWrapper> readAllBooks() {
        List<Book> books = mockBookService.getBooks();

        BookGetAllBooksSuccessWrapper bookGetAllBooksSuccessWrapper = new BookGetAllBooksSuccessWrapper(ResponseMessage.BOOKS_RETRIEVED_SUCCESS_MESSAGE, books);

        return ResponseEntity.ok(bookGetAllBooksSuccessWrapper);
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookResponseStatusWrapper> findBookById(@PathVariable long id) {
        Optional<Book> optionalBook = mockBookService.get(id);

        return optionalBook.map(book -> getBookStatusSuccessResponse(book, ResponseMessage.BOOK_RETRIEVED_SUCCESS_MESSAGE))
                .orElseGet(() -> getBookNotFoundResponse(id));

    }


    @PostMapping
    public ResponseEntity<BookResponseStatusWrapper> addBook(@RequestBody Book book) {
        log.info("{}", book);

        if (!doesBookToAddContainNullValues(book)) {
            mockBookService.add(book);
            return getBookStatusSuccessResponse(book, ResponseMessage.BOOK_ADDED_SUCCESS_MESSAGE);
        }

        return getBookBadRequestStatusResponse(ResponseMessage.NOT_ENOUGH_DATA_TO_SAVE_BOOK_MESSAGE);
    }


    private boolean doesBookToAddContainNullValues(Book book) {
        return book.getIsbn() == null
                || book.getAuthor() == null
                || book.getType() == null
                || book.getPublisher() == null
                || book.getTitle() == null;
    }


    @PutMapping
    public ResponseEntity<BookResponseStatusWrapper> updateBook(@RequestBody Book book) {
        Optional<Book> optionalBook = mockBookService.get(book.getId());

        if (doesBookToUpdateContainNullValues(book)) {
            return getBookBadRequestStatusResponse(ResponseMessage.NOT_ENOUGH_DATA_TO_UPDATE_BOOK_MESSAGE);
        }

        return optionalBook.map(foundBook -> {
                    mockBookService.update(book);
                    return getBookStatusSuccessResponse(book, ResponseMessage.BOOK_UPDATED_SUCCESS_MESSAGE);
                })
                .orElseGet(() -> getBookNotFoundResponse(book.getId()));

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
    public ResponseEntity<BookResponseStatusWrapper> deleteBook(@PathVariable long id) {
        Optional<Book> optionalBook = mockBookService.get(id);

        return optionalBook.map(foundBook -> {
                    mockBookService.delete(id);
                    return getBookStatusSuccessResponse(foundBook, ResponseMessage.BOOK_DELETED_SUCCESS_MESSAGE);
                })
                .orElseGet(() -> getBookNotFoundResponse(id));
    }


    private ResponseEntity<BookResponseStatusWrapper> getBookStatusSuccessResponse(Book book, String message) {
        BookResponseStatusWrapper bookResponseStatusWrapper = new BookResponseStatusWrapper("Success", message, book);

        return ResponseEntity.status(HttpStatus.OK)

                .body(bookResponseStatusWrapper);
    }

    private ResponseEntity<BookResponseStatusWrapper> getBookNotFoundResponse(long id) {
        BookResponseStatusWrapper bookResponseStatusWrapper = new BookResponseStatusWrapper("Failure", ResponseMessage.BOOK_NOT_FOUND_MESSAGE.formatted(id), null);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(bookResponseStatusWrapper);
    }

    private ResponseEntity<BookResponseStatusWrapper> getBookBadRequestStatusResponse(String message) {
        BookResponseStatusWrapper bookResponseStatusWrapper = new BookResponseStatusWrapper("Failure", message, null);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bookResponseStatusWrapper);
    }


}
