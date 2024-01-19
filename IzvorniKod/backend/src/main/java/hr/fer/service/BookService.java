package hr.fer.service;

import java.util.List;
import hr.fer.domain.Book;

public interface BookService {
    List<Book>  list();

    Book createBook(Book book);

    Book findByTitleAuthor(String title, String author);
}
