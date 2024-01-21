package org.proggers.backend.service;

import org.proggers.backend.entity.Book;
import org.proggers.backend.entity.Seller;

import java.util.List;

public interface BookService {

    List<Book> find (String type, String query);

    List<Book> list ();
    void add (Book book);

    List<Book> getSellersBooks (Seller seller);
}
