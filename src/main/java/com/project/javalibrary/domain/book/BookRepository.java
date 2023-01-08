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

    public List<Book> finaAll() {
        return new ArrayList<>(bookStorage.values());
    }

    public void clearStore() {
        bookStorage.clear();
    }
}
