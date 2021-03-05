package com.tekwill.java.fundamentals.bookspringboot.service;

import com.tekwill.java.fundamentals.bookspringboot.domain.Book;

import java.util.List;

public interface BookService {
    Book getBookByIsbn(String isbn);

    List<Book> getAllBooks();

    int updateBookNameByBookId(String newBookName, Long bookId);

    int deleteBook(Long bookId);

    Book getBookById(Long bookId);

    int saveBook(Book book);

    int update(Long id, Book book);
}
