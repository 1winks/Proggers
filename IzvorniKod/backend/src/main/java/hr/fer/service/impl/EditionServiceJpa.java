package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.domain.Edition;
import hr.fer.repository.BookRepository;
import hr.fer.repository.EditionRepository;
import hr.fer.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionServiceJpa implements EditionService {
    @Autowired
    private EditionRepository editionRepo;
    @Override
    public List<Edition> list() {
        return editionRepo.findAll();
    }
}
