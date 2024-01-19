package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.repository.BookRepository;
import hr.fer.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookServiceJpa implements BookService {
    @Autowired
    private BookRepository bookRepo;
    @Override
    public List<Book> list() {
        return bookRepo.findAll();
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public Book findByTitleAuthor(String title, String author) {
        List<Book> books = bookRepo.findByTitleAndAuthor(title, author);

        if (books == null || books.isEmpty()) {
            return null;
        }

        return books.get(0);
    }
}
