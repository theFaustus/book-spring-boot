package com.tekwill.java.fundamentals.bookspringboot.service;


import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
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
        return bookRepository.findBook(isbn);
    }

    @Override
    public List<Book> getAllBooks() {
        logger.debug("Entered getAllBooks");
        return bookRepository.findAll();
    }

    @Override
    public int updateBookNameByBookId(String newBookName, Long bookId) {
        return bookRepository.updateBookNameByBookId(newBookName, bookId);
    }

    @Override
    public int deleteBook(Long bookId) {
        logger.info("Entered deleteBook with bookId = {}", bookId);
        return bookRepository.deleteBook(bookId);
    }

    @Override
    public int saveBook(Book book) {
        return bookRepository.saveBook(book);
    }
}
