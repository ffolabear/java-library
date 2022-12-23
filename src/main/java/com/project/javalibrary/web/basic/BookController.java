package com.project.javalibrary.web.basic;

import com.project.javalibrary.domain.Book;
import com.project.javalibrary.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    public String bookInfo(Model model) {
        List<Book> bookStorage = bookRepository.finaAll();
        model.addAttribute("bookStorage", bookStorage);
        return "";
    }

}
