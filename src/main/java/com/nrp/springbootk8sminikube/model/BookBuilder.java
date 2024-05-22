package com.nrp.springbootk8sminikube.model;

import java.math.BigDecimal;

public class BookBuilder {

    private String id;
    private String title;
    private String isbn;
    private String description;
    private Integer pages;
    private BigDecimal price;

    public BookBuilder setId(String id) {
        this.id = id;
        return this;
    }

    public BookBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public BookBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public BookBuilder setPages(Integer pages) {
        this.pages = pages;
        return this;
    }

    public BookBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Book build() {
        return new Book(id, title, isbn, description, pages, price);
    }
}
