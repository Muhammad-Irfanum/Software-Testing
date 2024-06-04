package com.example.tdd;

import java.util.ArrayList;
import java.util.List;

public class TestBookRepository implements IBookRepository {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<>(books);
    }
}
