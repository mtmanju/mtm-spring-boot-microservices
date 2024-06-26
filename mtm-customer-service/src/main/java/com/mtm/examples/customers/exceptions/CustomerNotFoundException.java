package com.mtm.examples.customers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException(String pesel) {
        super("No such customer: " + pesel);
    }

}