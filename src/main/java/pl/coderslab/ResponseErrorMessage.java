package pl.coderslab;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseErrorMessage implements ResponseMessage {
    private final String status = "Error";
    private final String message;
}
