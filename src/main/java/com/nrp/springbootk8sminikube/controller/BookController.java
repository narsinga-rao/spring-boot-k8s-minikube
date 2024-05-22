package com.nrp.springbootk8sminikube.controller;

import com.nrp.springbootk8sminikube.model.Book;
import com.nrp.springbootk8sminikube.service.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final Logger log = LoggerFactory.getLogger(BookController.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /**
     * {@code POST  /book} : Create a new book.
     *
     * @param book the book to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new book.
     */
    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book) {
        log.debug("REST request to save Book : {}", book);
        return new ResponseEntity<>(bookService.create(book), HttpStatus.CREATED);
    }

    /**
     * {@code PUT  /book} : Updates an existing book.
     *
     * @param book the book to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated book,
     * or with status {@code 400 (Bad Request)} if the book is not valid,
     * or with status {@code 500 (Internal Server Error)} if the book couldn't be updated.
     */
    @PutMapping()
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book) {
        log.debug("REST request to update Book : {}", book);
        Book result = bookService.update(book);
        return ResponseEntity.ok().body(result);
    }

    /**
     * {@code GET  /book} : get all the books.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of book in body.
     */

    @GetMapping()
    public ResponseEntity<List<Book>> getAllBook() {
        log.debug("REST request to get all books");
        List<Book> lst = bookService.getAllBooks();

        return new ResponseEntity<>(lst,HttpStatus.OK);
    }

    /**
     * {@code GET  /book/:id} : get the "id" book.
     *
     * @param id the id of the book to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the book, or with status {@code 404 (Not Found)}.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> getOneBook(@PathVariable("id") String id) {
        log.debug("REST request to get Book : {}", id);
        Book e = bookService.getOne(id);

        return new ResponseEntity<>(e, HttpStatus.OK);
    }

    /**
     * {@code DELETE  /book/:id} : delete the "id" book.
     *
     * @param id the id of the book to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable("id") String id) {
        log.debug("REST request to delete Book : {}", id);
        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
