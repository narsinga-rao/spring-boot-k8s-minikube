package com.nrp.springbootk8sminikube.model;

import java.math.BigDecimal;

public class Book {

    private String id;
    private String title;
    private String isbn;
    private String description;
    private Integer pages;
    private BigDecimal price;

    public Book() {
    }

    public Book(String id, String title, String isbn, String description, Integer pages, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.description = description;
        this.pages = pages;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public static BookBuilder builder() {
        return new BookBuilder();
    }
}
