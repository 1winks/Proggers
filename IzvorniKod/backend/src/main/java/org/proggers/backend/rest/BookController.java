package org.proggers.backend.rest;

import org.proggers.backend.domain.Book;
import org.proggers.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("")
    public List<Book> listBooks() {
        return bookService.list();
    }

    @PostMapping("/add")
    public Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }
}
