package org.proggers.backend.service.impl;

import org.proggers.backend.entity.Book;
import org.proggers.backend.repository.BookRepository;
import org.proggers.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceJpa implements BookService {
    @Autowired
    BookRepository bookRepository;


    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }
}
