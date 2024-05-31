package pl.coderslab;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@Component
public class MockBookService implements BookService {

    private static Long nextId = 4L;

    private List<Book> books;

    public MockBookService() {

        this.books = new ArrayList<>(List.of(
                new Book(1L, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"),
                new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion", "programming"),
                new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion", "programming")
        ));
    }

    @Override
    public List<Book> getBooks() {
        return books;
    }

    @Override
    public Optional<Book> get(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public void add(Book book) {
        nextId++;
        book.setId(nextId);
        books.add(book);
    }

    @Override
    public void delete(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    @Override
    public void update(Book book) {
         Optional<Book> optionalBook = get(book.getId());
        optionalBook.ifPresent(book1 -> updateBook(book, book1));
    }

    private static void updateBook(Book sourceBook, Book destinationBook) {
            destinationBook.setIsbn(sourceBook.getIsbn());
            destinationBook.setType(sourceBook.getType());
            destinationBook.setTitle(sourceBook.getTitle());
            destinationBook.setAuthor(sourceBook.getAuthor());
            destinationBook.setPublisher(sourceBook.getPublisher());

    }
}
