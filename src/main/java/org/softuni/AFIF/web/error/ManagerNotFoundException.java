package org.softuni.AFIF.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND , reason = "Manager Not Found!")
public class ManagerNotFoundException extends RuntimeException {

    private int statusCode;

    public ManagerNotFoundException() {
        this.statusCode = 404;
    }

    public ManagerNotFoundException(String message) {
        super(message);
        this.statusCode = 404;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
