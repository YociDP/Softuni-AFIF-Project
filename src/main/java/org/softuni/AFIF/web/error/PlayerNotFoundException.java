package org.softuni.AFIF.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Player Not Found")
public class PlayerNotFoundException extends RuntimeException {
    private int statusCode;

    public PlayerNotFoundException() {
        this.statusCode = 404;
    }

    public PlayerNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
