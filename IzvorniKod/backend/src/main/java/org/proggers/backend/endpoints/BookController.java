package org.proggers.backend.endpoints;

import org.proggers.backend.dto.BookDTO;
import org.proggers.backend.entity.Book;
import org.proggers.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return "Welcome!";
    }

    @GetMapping("/list")
    public List<Book> list () {
        return bookService.list();
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add (@RequestBody BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        bookService.add(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
