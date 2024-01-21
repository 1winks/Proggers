package org.proggers.backend.service;

import org.proggers.backend.entity.Book;

import java.util.List;

public interface BookService {

    List<Book> list ();
    void add (Book book);
}
