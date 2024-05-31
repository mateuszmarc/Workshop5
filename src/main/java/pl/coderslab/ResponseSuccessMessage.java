package pl.coderslab;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResponseSuccessMessage implements ResponseMessage {
    private final String status = "Success";
    private final String message;
}
