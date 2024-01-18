package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.domain.BookEdition;
import hr.fer.repository.BookEditionRepository;
import hr.fer.repository.BookRepository;
import hr.fer.service.BookEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookEditionServiceJpa implements BookEditionService {
    @Autowired
    private BookEditionRepository bookEditionRepositoryRepo;
    @Override
    public List<BookEdition> list() {
        return bookEditionRepositoryRepo.findAll();
    }
}
