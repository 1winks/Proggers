package org.proggers.backend.service.impl;

import org.proggers.backend.entity.Book;
import org.proggers.backend.entity.Seller;
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
    public List<Book> getSellersBooks(Seller seller) {
        return bookRepository.findBySeller(seller);
    }

    @Override
    public List<Book> list() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> find(String type, String query) {
        return switch (type.toLowerCase()) {
            case "title" -> bookRepository.findByTitle(query);
            case "author" -> bookRepository.findByAuthor(query);
            case "isbn" -> bookRepository.findByIsbn(query);
            case "publicationYear" -> bookRepository.findByPublicationYear(Integer.parseInt(query));
            case "genre" -> bookRepository.findByGenre(query);
            case "publisher" -> bookRepository.findByPublisher(query);
            case "publisherCategory" -> bookRepository.findByPublisherCategory(Book.PublisherCategory.valueOf(query));
            case "condition" -> bookRepository.findByCondition(Book.Condition.valueOf(query.toUpperCase()));
            case "copies" -> bookRepository.findByCopies(Integer.parseInt(query));
            case "description" -> bookRepository.findByDescription(query);
            case "languageTag" -> bookRepository.findByLanguageTag(Book.LanguageTag.valueOf(query.toUpperCase()));
            default -> null;
        };
    }

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }
}
