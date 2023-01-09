package com.project.javalibrary.domain.book;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepository {

    private static final Map<Long, Book> bookStorage = new HashMap<>();
    private static long sequence = 0L;

    public Book save(Book book) {
        book.setId(++sequence);
        bookStorage.put(book.getId(), book);
        return book;
    }

    public Book findById(Long id) {
        return bookStorage.get(id);
    }

    public List<Book> findAll() {
        return new ArrayList<>(bookStorage.values());
    }

    public void update(Long bookId, Book updateBook) {
        Book findBook = findById(bookId);
        findBook.setTitle(updateBook.getTitle());
        findBook.setQuantity(updateBook.getQuantity());
    }

    public void clearStore() {
        bookStorage.clear();
    }
}
