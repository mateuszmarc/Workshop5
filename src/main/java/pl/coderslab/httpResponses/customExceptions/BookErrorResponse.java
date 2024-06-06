package pl.coderslab.httpResponses.customExceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BookErrorResponse {
    private final int responseStatusCode;
    private final String errorMessage;
}
