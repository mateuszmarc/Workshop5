package pl.coderslab.httpResponses;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import pl.coderslab.Book;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class BookGetAllBooksSuccessWrapper  {

    private final String status = "Success";
    private final String message;
    private final List<Book> books;

}
