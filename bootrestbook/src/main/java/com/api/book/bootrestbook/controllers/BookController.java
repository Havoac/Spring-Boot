package com.api.book.bootrestbook.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.book.bootrestbook.entities.Book;
import com.api.book.bootrestbook.services.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    // get all books handler
    @GetMapping("/books")
    public ResponseEntity<List<Book>> GetBooks() {
        List<Book> allBooks = this.bookService.GetAllBooks();

        if (allBooks.size() <= 0)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.CREATED).body(allBooks);
    }

    // get single book handler
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> GetBook(@PathVariable("id") int id) {
        Book book = bookService.GetBookById(id);

        if (book == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.of(Optional.of(book));
    }

    // new book add handler
    @PostMapping("/books")
    public ResponseEntity<Book> AddBook(@RequestBody Book book) {
        Book b = null;

        try {
            b = this.bookService.AddBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.of(Optional.of(b));
    }

    // delete book handler
    @DeleteMapping("/books/{bookId}")
    public ResponseEntity<Void> DeleteBook(@PathVariable("bookId") int bookId) {
        try {
            this.bookService.DeleteBook(bookId);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // update book handler
    @PutMapping("books/{bookId}")
    public ResponseEntity<Book> UpdateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        try {
            this.bookService.UpdateBook(book, bookId);
            return ResponseEntity.ok().body(book);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
