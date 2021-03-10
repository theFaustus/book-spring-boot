package com.tekwill.java.fundamentals.bookspringboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Data
@NoArgsConstructor
@Entity
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue
    private Long id;
    private String content;
    private int pageNumber;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Book book;

    public Page(Long id, String content, int pageNumber) {
        this.id = id;
        this.content = content;
        this.pageNumber = pageNumber;
    }

    public Page(Long id, String content, int pageNumber, Book book) {
        this.id = id;
        this.content = content;
        this.pageNumber = pageNumber;
        this.book = book;
    }

    public Page(String content, int pageNumber) {
        this.content = content;
        this.pageNumber = pageNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return Objects.equals(id, page.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
