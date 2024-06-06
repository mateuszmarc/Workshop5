package pl.coderslab.httpResponses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import pl.coderslab.Book;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class BookGetAllBooksOkResponseStatusWrapper {

    private final int responseStatusCode = HttpStatus.OK.value();
    private final String message;
    private final List<Book> books;

}
