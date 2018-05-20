package com.momenton.codechallenge.companyhierarchy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * custom employee not found exception
 *
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 6614352723991729874L;

    public EmployeeNotFoundException(String messege) {
	super(messege);
    }
}
