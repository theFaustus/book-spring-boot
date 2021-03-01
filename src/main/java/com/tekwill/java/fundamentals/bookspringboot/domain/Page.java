package com.tekwill.java.fundamentals.bookspringboot.domain;

import lombok.Data;

@Data
public class Page {
    private Long id;
    private String content;
    private int pageNumber;

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
