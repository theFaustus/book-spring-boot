package com.tekwill.java.fundamentals.bookspringboot.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Page {
    private Long id;
    private String content;
    private int pageNumber;

    @JsonIgnore
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
    public String toString() {
        return "Page{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", pageNumber=" + pageNumber +
                '}';
    }
}
