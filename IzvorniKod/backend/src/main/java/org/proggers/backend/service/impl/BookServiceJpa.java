package org.proggers.backend.service.impl;

import org.proggers.backend.dao.BookRepository;
import org.proggers.backend.domain.Book;
import org.proggers.backend.service.BookService;
import org.proggers.backend.service.RequestDeniedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
        Assert.notNull(book, "Book object can't be null.");
        Assert.isNull(book.getId(), "Book ID must be null.");

        Assert.notNull(book.getTitle(), "Book must have a title.");
        Assert.hasText(book.getTitle(), "Book must have a title.");

        Assert.notNull(book.getAuthor(), "Book must have a author.");
        Assert.hasText(book.getAuthor(), "Book must have a author.");

        Assert.notNull(book.getCover(), "Book must have a cover.");
        Assert.hasText(book.getCover(), "Book must have a cover.");

        Assert.notNull(book.getDescription(), "Book must have a description.");
        Assert.hasText(book.getDescription(), "Book must have a description.");

        Assert.notNull(book.getGenre(), "Book must have a genre.");
        Assert.hasText(book.getGenre(), "Book must have a genre.");

        if(bookRepo.countByAuthor(book.getAuthor())>0
                && bookRepo.countByCover(book.getCover())>0 && bookRepo.countByGenre(book.getGenre())>0
                && bookRepo.countByTitle(book.getTitle())>0 && bookRepo.countByDescription(book.getDescription())>0)
            throw new RequestDeniedException("The same book already exists");

        return bookRepo.save(book);
    }
}
