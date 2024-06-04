package com.example.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookServiceTest {

    private BookService bookService;
    private TestBookRepository testBookRepository;

    @BeforeEach
    public void setUp() {
        testBookRepository = new TestBookRepository();
        testBookRepository.addBook(new Book("1", "Test Driven Development", "Kent Beck"));
        testBookRepository.addBook(new Book("2", "Clean Code", "Robert C. Martin"));
        testBookRepository.addBook(new Book("3", "Effective Java", "Joshua Bloch"));
        testBookRepository.addBook(new Book("4", "Refactoring", "Martin Fowler"));
        testBookRepository.addBook(new Book("5", "Clean Architecture", "Robert C. Martin"));

        bookService = new BookService(testBookRepository);
    }

    @Test
    public void testGetBooksByAuthor() {
        List<Book> books = bookService.getBooksByAuthor("Kent Beck");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthor_NoBooksFound() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookService.getBooksByAuthor("Unknown Author");
        });
    }

    @Test
    public void testGetBooksByAuthor_MultipleBooksFound() {
        testBookRepository.addBook(new Book("6", "Some Other Book", "Robert C. Martin"));
        List<Book> books = bookService.getBooksByAuthor("Robert C. Martin");
        Assertions.assertEquals(3, books.size());
    }

    @Test
    public void testGetBooksByAuthor_CaseInsensitive() {
        List<Book> books = bookService.getBooksByAuthor("robert c. martin");
        Assertions.assertEquals(2, books.size());
    }

    @Test
    public void testGetBooksByAuthor_SpecialCharacters() {
        testBookRepository.addBook(new Book("6", "Book with Special Characters", "Robert C. Martin"));
        List<Book> books = bookService.getBooksByAuthor("Robert C. Martin");
        Assertions.assertEquals(3, books.size());
    }

    @Test
    public void testGetBooksByTitle() {
        List<Book> books = bookService.getBooksByTitle("Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Robert C. Martin", books.get(0).getAuthor());
    }

    @Test
    public void testGetBooksByTitle_NoBooksFound() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookService.getBooksByTitle("Unknown Title");
        });
    }

    @Test
    public void testGetBooksByTitle_MultipleBooksFound() {
        testBookRepository.addBook(new Book("6", "Effective Java", "Another Author"));
        List<Book> books = bookService.getBooksByTitle("Effective Java");
        Assertions.assertEquals(2, books.size());
    }

    @Test
    public void testGetBooksByTitle_CaseInsensitive() {
        List<Book> books = bookService.getBooksByTitle("clean code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByTitle_SpecialCharacters() {
        testBookRepository.addBook(new Book("6", "Refactoring!", "Martin Fowler"));
        List<Book> books = bookService.getBooksByTitle("Refactoring!");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Martin Fowler", books.get(0).getAuthor());
    }

    @Test
    public void testGetBooksByAuthorAndTitle() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Clean Code");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_NoBooksFound() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookService.getBooksByAuthorAndTitle("Unknown Author", "Unknown Title");
        });
    }

    @Test
    public void testGetBooksByAuthorAndTitle_MultipleBooksFound() {
        testBookRepository.addBook(new Book("7", "Test Driven Development", "Kent Beck"));
        List<Book> books = bookService.getBooksByAuthorAndTitle("Kent Beck", "Test Driven Development");
        Assertions.assertEquals(2, books.size());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_CaseInsensitive() {
        List<Book> books = bookService.getBooksByAuthorAndTitle("kent beck", "test driven development");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Test Driven Development", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_SpecialCharacters() {
        testBookRepository.addBook(new Book("8", "Clean Code!", "Robert C. Martin"));
        List<Book> books = bookService.getBooksByAuthorAndTitle("Robert C. Martin", "Clean Code!");
        Assertions.assertEquals(1, books.size());
        Assertions.assertEquals("Clean Code!", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByAuthorAndTitle_EmptyStrings() {
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            bookService.getBooksByAuthorAndTitle("", "");
        });
    }
}
