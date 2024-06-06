package pl.coderslab.httpResponses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.coderslab.Book;

@RequiredArgsConstructor
@Getter
public class BookOkResponseStatusWrapper {

    private final int responseStatusCode;
    private final String message;
    private final Book book;


}
