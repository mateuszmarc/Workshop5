package pl.coderslab.httpResponses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.coderslab.Book;

@RequiredArgsConstructor
@Getter
public class BookResponseStatusWrapper {

    private final String status;
    private final String message;
    private final Book book;

}
