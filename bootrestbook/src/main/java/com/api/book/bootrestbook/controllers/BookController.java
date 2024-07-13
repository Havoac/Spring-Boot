package com.api.book.bootrestbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Book> GetBooks() {
        return this.bookService.GetAllBooks();
    }

    // get single book handler
    @GetMapping("/books/{id}")
    public Book GetBook(@PathVariable("id") int id) {
        return bookService.GetBookById(id);
    }

    // new book add handler
    @PostMapping("/books")
    public Book AddBook(@RequestBody Book book) {
        return this.bookService.AddBook(book);
    }

    // delete book handler
    @DeleteMapping("/books/{bookId}")
    public List<Book> DeleteBook(@PathVariable("bookId") int bookId) {
        return this.bookService.DeleteBook(bookId);
    }

    // update book handler
    @PutMapping("books/{bookId}")
    public Book UpdateBook(@RequestBody Book book, @PathVariable("bookId") int bookId) {
        return this.bookService.UpdateBook(book, bookId);
    }
}
