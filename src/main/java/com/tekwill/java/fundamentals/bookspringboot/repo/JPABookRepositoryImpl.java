package com.tekwill.java.fundamentals.bookspringboot.repo;

import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
//@Primary one possible solution to multiple beans

public class JPABookRepositoryImpl implements BookRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book findBookByISBN(String isbn) {
        return entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.pages WHERE b.isbn = :isbn", Book.class)
                .setParameter("isbn", isbn)
                .getSingleResult();
    }

    @Override
    public Book findBookById(Long bookId) {
        return entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.pages WHERE b.id = :bookId", Book.class)
                .setParameter("bookId", bookId)
                .getSingleResult();
    }

    @Override
    public List<Book> findAll() {
        return entityManager.createQuery("SELECT b FROM Book b JOIN FETCH b.pages", Book.class).getResultList();
    }

    @Override
    public int updateBookNameByBookId(String newBookName, Long bookId) {
        return entityManager.createQuery("UPDATE Book b SET b.name = :newBookName WHERE b.id = :bookId")
                .setParameter("newBookName", newBookName)
                .setParameter("bookId", bookId)
                .executeUpdate();
    }

    @Override
    public int deleteBook(Long bookId) {
        entityManager.createQuery("DELETE FROM Page p WHERE p.book.id = :bookId")
                .setParameter("bookId", bookId)
                .executeUpdate();
        return entityManager.createQuery("DELETE FROM Book b WHERE b.id = :bookId")
                .setParameter("bookId", bookId)
                .executeUpdate();
    }

    @Override
    public int saveBook(Book book) {
        entityManager.persist(book);
        return 1;
    }
}
