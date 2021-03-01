package com.tekwill.java.fundamentals.bookspringboot.repo;



import com.tekwill.java.fundamentals.bookspringboot.domain.Book;

import java.util.List;

public interface BookRepository {
    Book findBook(String isbn);

    List<Book> findAll();

    int updateBookNameByBookId(String newBookName, Long bookId);

    int deleteBook(Long bookId);

    int saveBook(Book book);
}
