package com.tekwill.java.fundamentals.bookspringboot.domain.exceptions;

public class BookNotFoundRuntimeException extends RuntimeException {
    public BookNotFoundRuntimeException(String s) {
        super(s);
    }
}
