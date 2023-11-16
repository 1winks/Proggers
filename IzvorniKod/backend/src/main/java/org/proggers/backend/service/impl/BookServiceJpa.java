package org.proggers.backend.service.impl;

import org.proggers.backend.dao.BookRepository;
import org.proggers.backend.domain.Book;
import org.proggers.backend.service.BookService;
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
        // TODO: nadopuniti (ovo je omogućeno registriranima)
        return null;
    }
}
