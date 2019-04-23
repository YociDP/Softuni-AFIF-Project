package org.softuni.AFIF.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Club Not Found")
public class ClubNotFoundException extends RuntimeException {
    private int statusCode;

    public ClubNotFoundException() {
        this.statusCode = 404;
    }

    public ClubNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
