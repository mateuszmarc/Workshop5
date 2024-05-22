package pl.coderslab;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
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
        return List.of();
    }

    @Override
    public Optional<Book> get(Long id) {
        return Optional.empty();
    }

    @Override
    public void add(Book book) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Book book) {

    }
}
