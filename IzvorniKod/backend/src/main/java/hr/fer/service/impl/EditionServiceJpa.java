package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.domain.BookEdition;
import hr.fer.domain.Edition;
import hr.fer.dto.EditionDTO;
import hr.fer.dto.SearchDTO;
import hr.fer.repository.BookEditionRepository;
import hr.fer.repository.BookRepository;
import hr.fer.repository.EditionRepository;
import hr.fer.service.BookService;
import hr.fer.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;

@Service
public class EditionServiceJpa implements EditionService {
    @Autowired
    private EditionRepository editionRepo;

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository bookRepo;

    @Autowired
    private BookEditionRepository bookEditionRepository;

    @Override
    public List<Edition> list() {
        return editionRepo.findAll();
    }

    @Override
    public Edition addEdition(EditionDTO editionDTO) {
        Assert.notNull(editionDTO, "Edition DTO must not be null");

        Book book = bookService.findByTitleAuthor(editionDTO.getTitle(), editionDTO.getAuthor());

        // TODO: Create book aswell
        Assert.notNull(book, "Edition must have valid book.");

        Edition edition = new Edition(editionDTO);

        BookEdition bookEdition = new BookEdition(book, edition);

        edition.link(bookEdition);
        book.link(bookEdition);

        // TODO: Add service methods instead of direct repo access
        bookRepo.save(book);
        editionRepo.save(edition);
        bookEditionRepository.save(bookEdition);
        return edition;
    }

    @Override
    public List<Edition> searchEdition(SearchDTO search) {
        if (search.getCategory().equals("TITLE")) {
            bookRepo.findByTitle(search.getQuery());
        }
        return null;
    }
}
