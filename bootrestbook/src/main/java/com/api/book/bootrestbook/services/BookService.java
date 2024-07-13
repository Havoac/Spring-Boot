package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    @Autowired
    BookRepository bookRepository;

    // static List<Book> list = new ArrayList<>();

    // static {
    // list.add(new Book(2, "Complete C++", "William"));
    // list.add(new Book(3, "Complete Python", "Nathasha"));
    // }

    // get all books
    public List<Book> GetAllBooks() {
        return (List<Book>) this.bookRepository.findAll();
    }

    // get single book by id
    public Book GetBookById(int id) {
        Book book = null;
        List<Book> list = GetAllBooks();

        // book = list.stream().filter(e -> e.getId() == id).findFirst().get();

        try {
            for (Book tempBook : list) {
                if (tempBook.getId() == id) {
                    book = tempBook;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return book;
    }

    // adding the book
    public Book AddBook(Book b) {
        return bookRepository.save(b);
    }

    public List<Book> DeleteBook(int bId) {
        List<Book> totalDeletedBooks = new ArrayList<Book>();
        List<Book> list = GetAllBooks();

        for (Book b : list) {
            if (b.getId() == bId)
                totalDeletedBooks.add(b);
        }

        for (Book b : totalDeletedBooks)
            this.bookRepository.deleteById(b.getId());

        return totalDeletedBooks;
    }

    public Book UpdateBook(Book book, int bId) {
        // List<Book> list = GetAllBooks();

        // for (Book b : list) {
        // if (b.getId() == bId) {
        // b.setAuthor(book.getAuthor());
        // b.setTitle(book.getTitle());

        // }
        // }

        book.setId(bId);
        this.bookRepository.save(book);

        return book;
    }
}
