package com.project.javalibrary.domain;

import org.assertj.core.api.Assertions;
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
        Book registeredBook = bookRepository.registerBook(book);

        //then
        Book findBook = bookRepository.findById(book.getId());
        assertThat(findBook.getId()).isEqualTo(registeredBook.getId());
    }

    @Test
    void findAll() {
        //given
        Book book1 = new Book("Basic java", 5);
        Book book2 = new Book("Basic Python", 4);
        bookRepository.registerBook(book1);
        bookRepository.registerBook(book2);

        //when
        List<Book> result = bookRepository.finaAll();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(book1, book2);
    }

}
