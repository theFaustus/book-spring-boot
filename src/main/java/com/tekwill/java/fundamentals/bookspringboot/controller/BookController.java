package com.tekwill.java.fundamentals.bookspringboot.controller;


import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
import com.tekwill.java.fundamentals.bookspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping( "/{bookId}")
    public Book getBookById(@PathVariable Long bookId){
        return bookService.getBookById(bookId);
    }

    @GetMapping
    public String foo(){
        return "Hello my dear students! Read! Code! Experiment!";
    }

}
