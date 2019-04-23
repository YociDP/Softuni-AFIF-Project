package org.softuni.AFIF.web.error;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Pitch Not Found")
public class PitchNotFoundException extends RuntimeException {
    private int statusCode;

    public PitchNotFoundException() {
        this.statusCode = 404;
    }

    public PitchNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
