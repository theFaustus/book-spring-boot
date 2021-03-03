package com.tekwill.java.fundamentals.bookspringboot.repo;



import com.tekwill.java.fundamentals.bookspringboot.domain.Book;

import java.util.List;

public interface BookRepository {
    Book findBookByISBN(String isbn);

    Book findBookById(Long bookId);

    List<Book> findAll();

    int updateBookNameByBookId(String newBookName, Long bookId);

    int deleteBook(Long bookId);

    int saveBook(Book book);
}
