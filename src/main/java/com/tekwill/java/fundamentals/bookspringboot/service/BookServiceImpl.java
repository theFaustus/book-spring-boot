package com.tekwill.java.fundamentals.bookspringboot.service;


import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
import com.tekwill.java.fundamentals.bookspringboot.domain.exceptions.BookNotFoundRuntimeException;
import com.tekwill.java.fundamentals.bookspringboot.repo.BookRepository;
import com.tekwill.java.fundamentals.bookspringboot.repo.SpringDataJpaBookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
//    @Qualifier("JPABookRepositoryImpl") //another solution to multiple beans
//    private final BookRepository bookRepository;
    private final SpringDataJpaBookRepository bookRepository;

    @Override
    @Transactional
    public Book getBookByIsbn(String isbn) {
        logger.info("Entered getBookByIsbn with isbn = {}", isbn);
        return bookRepository.findByIsbn(isbn);
    }

    @Override
    @Transactional
    public List<Book> getAllBooks() {
        logger.debug("Entered getAllBooks");
        return bookRepository.findAll();
    }

    @Override
    @Transactional
    public int updateBookNameByBookId(String newBookName, Long bookId) {
        final Optional<Book> byId = bookRepository.findById(bookId);
        if(!byId.isPresent())
            throw new BookNotFoundRuntimeException(String.format("Book with id [%s] not found", bookId));
        bookRepository.updateBookNameById(newBookName, bookId);
        return 1;
    }

    @Override
    @Transactional
    public int deleteBook(Long bookId) {
        final Optional<Book> byId = bookRepository.findById(bookId);
        if(!byId.isPresent())
            throw new BookNotFoundRuntimeException(String.format("Book with id [%s] not found", bookId));
        logger.info("Entered deleteBook with bookId = {}", bookId);
        bookRepository.deleteById(bookId);
        return 1;
    }

    @Override
    @Transactional
    public Book getBookById(Long bookId) {
        final Optional<Book> byId = bookRepository.findById(bookId);
        if(!byId.isPresent())
            throw new BookNotFoundRuntimeException(String.format("Book with id [%s] not found", bookId));
        return byId.get();
    }

    @Override
    @Transactional
    public int saveBook(Book book) {
        book.getPages().forEach(p -> p.setBook(book));
        bookRepository.save(book);
        return 1;
    }

    @Override
    @Transactional
    public int update(Long id, Book book) {
        if(book.getName() != null)
            return updateBookNameByBookId(book.getName(), id);
        //else if do for all the fields
        return 0;
    }
}
