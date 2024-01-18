package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.domain.EditionOffer;
import hr.fer.repository.BookRepository;
import hr.fer.repository.EditionOfferRepository;
import hr.fer.service.EditionOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EditionOfferServiceJpa implements EditionOfferService {
    @Autowired
    private EditionOfferRepository editionOfferRepository;
    @Override
    public List<EditionOffer> list() {
        return editionOfferRepository.findAll();
    }
}
