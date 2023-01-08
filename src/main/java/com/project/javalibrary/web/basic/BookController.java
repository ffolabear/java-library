package com.project.javalibrary.web.basic;

import com.project.javalibrary.domain.book.Book;
import com.project.javalibrary.domain.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/bookList")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    @GetMapping
    public String bookList(Model model) {
        List<Book> bookStorage = bookRepository.finaAll();
        model.addAttribute("bookStorage", bookStorage);
        return "basic/bookList";
    }

    @GetMapping("/{bookId}")
    public String bookInfo(@PathVariable long bookId, Model model) {
        Book book = bookRepository.findById(bookId);
        model.addAttribute("book", book);
        return "basic/bookDetail";
    }

    @PostMapping
    public String registerBook(Book book, RedirectAttributes redirectAttributes) {
        Book registeredBook = bookRepository.save(book);
        redirectAttributes.addAttribute("bookId", registeredBook.getId());
        redirectAttributes.addAttribute("status", true);
        return "";
    }

    @GetMapping("/{bookId}/edit")

    @PostConstruct
    public void testDataAdd() {
        bookRepository.save(new Book("Java-Basic", 10));
        bookRepository.save(new Book("Python-Basic", 5));
        bookRepository.save(new Book("JavaScript-Basic", 3));
        bookRepository.save(new Book("Clean Code", 7));
    }
}
