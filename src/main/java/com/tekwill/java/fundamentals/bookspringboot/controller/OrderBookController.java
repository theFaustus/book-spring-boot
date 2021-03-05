package com.tekwill.java.fundamentals.bookspringboot.controller;


import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
import com.tekwill.java.fundamentals.bookspringboot.domain.exceptions.BookNotFoundRuntimeException;
import com.tekwill.java.fundamentals.bookspringboot.service.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order/books")
@Slf4j
//non-sense class for demo purposes
public class OrderBookController {
    private final BookService bookService;

    @GetMapping( "/{bookId}")
    public ResponseEntity<?> getBookById(@PathVariable Long bookId){
        final Book bookById = bookService.getBookById(bookId);
        return ResponseEntity.ok(bookById);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBookById(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @DeleteMapping( "/{bookId}")
    public ResponseEntity<String> deleteBookById(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
        return ResponseEntity.ok(String.format("Deleted book with id %s", bookId));
    }

    @PostMapping
    //not very good approach, should return the newly created resource
    public ResponseEntity<Integer> createBook(@RequestBody Book book){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(book));
    }

    @PatchMapping( "/{bookId}")
    public ResponseEntity<String> updateBookById(@PathVariable Long bookId, @RequestBody Book book){
        bookService.update(bookId, book);
        //not the best status, example purpose only
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(String.format("Updated book with id %s", bookId));
    }

}
