package hr.fer.service;

import java.util.List;
import hr.fer.domain.Book;
import hr.fer.dto.BookDTO;

public interface BookService {
    List<Book>  list();

    Book createBook(BookDTO book);

    Book findByTitleAuthor(String title, String author);
}
