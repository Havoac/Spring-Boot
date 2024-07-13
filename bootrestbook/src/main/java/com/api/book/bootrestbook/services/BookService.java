package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(2, "Complete C++", "William"));
        list.add(new Book(3, "Complete Python", "Nathasha"));
    }

    // get all books
    public List<Book> GetAllBooks() {
        return list;
    }

    // get single book by id
    public Book GetBookById(int id) {
        Book book = null;
        // book = list.stream().filter(e -> e.getId() == id).findFirst().get();

        for (Book tempBook : list) {
            if (tempBook.getId() == id) {
                book = tempBook;
                break;
            }
        }

        return book;
    }

    // adding the book
    public Book AddBook(Book b) {
        list.add(b);
        return b;
    }
}
