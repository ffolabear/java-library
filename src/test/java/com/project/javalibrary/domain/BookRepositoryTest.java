package com.project.javalibrary.domain;

import com.project.javalibrary.domain.book.Book;
import com.project.javalibrary.domain.book.BookRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class BookRepositoryTest {

    BookRepository bookRepository = new BookRepository();

    @AfterEach
    void afterEach() {
        bookRepository.clearStore();
    }

    @Test
    void register() {
        //given
        Book book = new Book("Basic java", 5);

        //when
        Book registeredBook = bookRepository.save(book);

        //then
        Book findBook = bookRepository.findById(book.getId());
        assertThat(findBook.getId()).isEqualTo(registeredBook.getId());
    }

    @Test
    void findAll() {
        //given
        Book book1 = new Book("Basic java", 5);
        Book book2 = new Book("Basic Python", 4);
        bookRepository.save(book1);
        bookRepository.save(book2);

        //when
        List<Book> result = bookRepository.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(book1, book2);
    }

}
