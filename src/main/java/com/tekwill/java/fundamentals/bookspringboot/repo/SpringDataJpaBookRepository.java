package com.tekwill.java.fundamentals.bookspringboot.repo;

import com.tekwill.java.fundamentals.bookspringboot.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaBookRepository extends JpaRepository<Book, Long> {
    Book findByIsbn(String isbn);

    @Query("UPDATE Book b SET b.name = :bookName WHERE b.id = :bookId")
    @Modifying
    void updateBookNameById(String bookName, Long bookId);

    @Query(value = "UPDATE books b SET name = :bookName WHERE b.id = :bookId", nativeQuery = true)
    @Modifying
    void updateNativeBookNameById(String bookName, Long bookId);
}
