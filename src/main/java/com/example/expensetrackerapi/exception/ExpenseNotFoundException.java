package com.example.expensetrackerapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ExpenseNotFoundException extends RuntimeException{
    @Serial
    private static final long serialVersionUID=1L;

    public ExpenseNotFoundException(String message)
    {
        super(message);
    }
}
