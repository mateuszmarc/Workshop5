package pl.coderslab.httpResponses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import pl.coderslab.Book;

@RequiredArgsConstructor
@Getter
public class BookOkResponseStatusWrapper {

    private final int responseStatusCode = HttpStatus.OK.value();
    private final Book book;
    private final String message;

}
