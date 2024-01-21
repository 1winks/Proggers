package org.proggers.backend.endpoints;

import org.proggers.backend.dto.BookQueryDTO;
import org.proggers.backend.entity.Book;
import org.proggers.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("")
    public String ping () {
        return "/api/books";
    }

    @GetMapping("/list")
    public List<Book> list () {
        return bookService.list();
    }

    @PostMapping("/find")
    public List<Book> find (@RequestBody BookQueryDTO bookQueryDTO) {
        List<Book> books = bookService.find(bookQueryDTO.getType(), bookQueryDTO.getQuery());
        System.out.println(books.size());

        return books;
    }

}
