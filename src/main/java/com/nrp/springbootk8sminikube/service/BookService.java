package com.nrp.springbootk8sminikube.service;

import com.nrp.springbootk8sminikube.model.Book;

import java.util.List;

public interface BookService {

    Book create(Book d);
    Book update(Book d);
    Book getOne(String id);
    List<Book> getAllBooks();
    void delete(String id);

}
