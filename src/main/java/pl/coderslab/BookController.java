package pl.coderslab;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private static final ObjectMapper objectMapper = new ObjectMapper();
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
}
