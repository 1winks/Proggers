package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.domain.Offer;
import hr.fer.repository.BookRepository;
import hr.fer.repository.OfferRepository;
import hr.fer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceJpa implements OfferService {
    @Autowired
    private OfferRepository offerRepo;
    @Override
    public List<Offer> list() {
        return offerRepo.findAll();
    }
}
