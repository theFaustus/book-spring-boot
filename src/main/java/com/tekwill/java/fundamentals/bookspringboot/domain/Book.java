package com.tekwill.java.fundamentals.bookspringboot.domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String name;
    private boolean isRare;
    private int numberOfPages;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Page> pages = new HashSet<>();

    public Book(Long id, String isbn, String name, boolean isRare, int numberOfPages) {
        this.id = id;
        this.isbn = isbn;
        this.name = name;
        this.isRare = isRare;
        this.numberOfPages = numberOfPages;
    }

    public Book(String isbn, String name, boolean isRare, int numberOfPages) {
        this.isbn = isbn;
        this.name = name;
        this.isRare = isRare;
        this.numberOfPages = numberOfPages;
    }

    public void addPage(Page page) {
        pages.add(page);
        page.setBook(this);
    }

    public void removePage(Page page) {
        pages.remove(page);
        page.setBook(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(this.id, book.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
