package com.tekwill.java.fundamentals.bookspringboot.service;


import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
import com.tekwill.java.fundamentals.bookspringboot.domain.exceptions.BookNotFoundRuntimeException;
import com.tekwill.java.fundamentals.bookspringboot.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
    private final BookRepository bookRepository;

    @Override
    public Book getBookByIsbn(String isbn) {
        logger.info("Entered getBookByIsbn with isbn = {}", isbn);
        return bookRepository.findBookByISBN(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        logger.debug("Entered getAllBooks");
        return bookRepository.findAll();
    }

    @Override
    public int updateBookNameByBookId(String newBookName, Long bookId) {
        final Book bookById = bookRepository.findBookById(bookId);
        if(bookById == null)
            throw new BookNotFoundRuntimeException(String.format("Book with id [%s] not found", bookId));
        return bookRepository.updateBookNameByBookId(newBookName, bookId);
    }

    @Override
    public int deleteBook(Long bookId) {
        final Book bookById = bookRepository.findBookById(bookId);
        if(bookById == null)
            throw new BookNotFoundRuntimeException(String.format("Book with id [%s] not found", bookId));
        logger.info("Entered deleteBook with bookId = {}", bookId);
        return bookRepository.deleteBook(bookId);
    }

    @Override
    public Book getBookById(Long bookId) {
        final Book bookById = bookRepository.findBookById(bookId);
        if(bookById == null)
            throw new BookNotFoundRuntimeException(String.format("Book with id [%s] not found", bookId));
        return bookById;
    }

    @Override
    public int saveBook(Book book) {
        return bookRepository.saveBook(book);
    }

    @Override
    public int update(Long id, Book book) {
        if(book.getName() != null)
            return updateBookNameByBookId(book.getName(), id);
        //else if do for all the fields
        return 0;
    }
}
