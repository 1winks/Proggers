package org.proggers.backend.service;

import org.proggers.backend.domain.Book;
import org.proggers.backend.domain.Seller;
import java.util.List;

/**
 * Service Wrapper that manages DB calls related to Sellers.
 * @see Book
 */
public interface BookService {
    List<Book> list();

    Book createBook(Book book);
}
