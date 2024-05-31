package pl.coderslab;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
