package com.project.javalibrary.web.basic;

import com.project.javalibrary.domain.Book;
import com.project.javalibrary.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/bookList")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public String bookInfo(Model model) {
        List<Book> bookStorage = bookRepository.finaAll();
        model.addAttribute("bookStorage", bookStorage);
        return "basic/bookList";
    }

    @PostConstruct
    public void testDataAdd() {
        bookRepository.registerBook(new Book("Java-Basic", 10));
        bookRepository.registerBook(new Book("Python-Basic", 5));
        bookRepository.registerBook(new Book("JavaScript-Basic", 3));
        bookRepository.registerBook(new Book("Clean Code", 7));
    }
}
