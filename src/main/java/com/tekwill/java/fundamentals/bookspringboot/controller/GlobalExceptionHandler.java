package com.tekwill.java.fundamentals.bookspringboot.controller;

import com.tekwill.java.fundamentals.bookspringboot.domain.exceptions.BookNotFoundRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.tekwill.java.fundamentals.bookspringboot.controller")
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(BookNotFoundRuntimeException.class)
    public ResponseEntity<String> handleBookNotFound(BookNotFoundRuntimeException e){
        log.error(e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

}
