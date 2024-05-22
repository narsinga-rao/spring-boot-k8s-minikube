package com.nrp.springbootk8sminikube.repository;

import com.nrp.springbootk8sminikube.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@Repository
public class BookRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookRepository.class);

    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        IntStream.range(0, 10).forEach(i -> books.add(Book.builder()
                .setId(String.valueOf(i))
                .setIsbn("IBN"+i)
                .setTitle("TITLE"+i)
                .setDescription("Desc"+i)
                .setPages(100+i)
                .setPrice(BigDecimal.valueOf(1000L+i))
                .build()));
    }

    public Book save(Book book) {
        return book;
    }

    public Book update(Book book) {
        return book;
    }

    public Optional<Book> findById(String id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public List<Book> findAll() {
        return books;
    }

    public void deleteById(String id) {
        LOGGER.info("Deleting book with id {}", id);
    }

}
