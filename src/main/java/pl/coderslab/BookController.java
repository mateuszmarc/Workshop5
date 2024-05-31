package pl.coderslab;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);
    private final MockBookService mockBookService;

    @RequestMapping("/helloBook")
    public Book helloBook() {

        Book book =  new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
        logger.info("{}", book);
        return book;
    }

    @GetMapping
    public List<Book> readAllBooks() {
        return mockBookService.getBooks();
    }
}
