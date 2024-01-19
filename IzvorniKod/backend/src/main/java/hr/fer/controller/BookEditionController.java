package hr.fer.controller;

import hr.fer.domain.Book;
import hr.fer.domain.BookEdition;
import hr.fer.service.BookEditionService;
import hr.fer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/book-edition")
public class BookEditionController {
    @Autowired
    private BookEditionService bookEditionService;

    @GetMapping("")
    public List<BookEdition> listBookEditions() {
        return bookEditionService.list();
    }
}
