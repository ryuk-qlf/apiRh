package fr.facil.facilapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DocumentPositionNotFoundException extends RuntimeException {
    public DocumentPositionNotFoundException(String s) {
        super(s);
    }
}
