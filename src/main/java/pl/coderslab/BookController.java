package pl.coderslab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final MockBookService mockBookService;

    @RequestMapping("/helloBook")
    public Book helloBook() {

        Book book =  new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        log.info("{}", book);
        return book;
    }

    @GetMapping
    public ResponseEntity<List<Book>> readAllBooks() {
        List<Book> books = mockBookService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable long id) {
        Optional<Book> optionalBook = mockBookService.get(id);
        return optionalBook.map(ResponseEntity::ok).orElseGet(() -> getBookNotFoundErrorMessage(id));
    }

    private static ResponseEntity<Book> getBookNotFoundErrorMessage(long id) {
        log.info("Could not find book with id: %s".formatted(id));
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        log.info("{}", book);

        if (doesBookToAddContainNullValues(book)) {
            mockBookService.add(book);
            return ResponseEntity.ok(book);
        }

        return getBadRequestForBookAdditionError();
    }

    private static ResponseEntity<Book> getBadRequestForBookAdditionError() {
        log.info("All fields of book instance must be populated to add book to the list");
        return ResponseEntity.badRequest().build();
    }

    private boolean doesBookToAddContainNullValues(Book book) {
        return book.getIsbn() != null
                && book.getAuthor() != null
                && book.getType() != null
                && book.getPublisher() != null
                && book.getTitle() != null;
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {
        Optional<Book> optionalBook = mockBookService.get(book.getId());

        if (optionalBook.isEmpty()) {
            return getBookNotFoundErrorMessage(book.getId());
        }

        if (doesBookToUpdateContainNullValues(book)) {
            return getBadRequestForBookUpdateError();
        }

        mockBookService.update(book);
        return ResponseEntity.ok(book);

    }

    private static ResponseEntity<Book> getBadRequestForBookUpdateError() {
        log.info("All fields of book instance must be populated to update book to the list");
        return ResponseEntity.badRequest().build();
    }

    private boolean doesBookToUpdateContainNullValues(Book book) {
        return book.getId() == null
                || book.getIsbn() == null
                || book.getAuthor() == null
                || book.getType() == null
                || book.getPublisher() == null
                || book.getTitle() == null;
    }
}
