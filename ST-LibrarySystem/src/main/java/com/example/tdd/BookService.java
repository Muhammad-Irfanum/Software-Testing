package com.example.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findAllBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());

        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found by author: " + author);
        }

        return books;
    }

    public Book getBookById(String id) {
        return bookRepository.findAllBooks().stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Book> getBooksByTitle(String title) {
        List<Book> books = bookRepository.findAllBooks().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());

        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found with title: " + title);
        }

        return books;
    }

    public List<Book> getBooksByAuthorAndTitle(String author, String title) {
        List<Book> books = bookRepository.findAllBooks().stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author) && book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());

        if (books.isEmpty()) {
            throw new BookNotFoundException("No books found by author: " + author + " and title: " + title);
        }

        return books;
    }
}
