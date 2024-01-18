package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.domain.OfferSeller;
import hr.fer.repository.BookRepository;
import hr.fer.repository.OfferSellerRepository;
import hr.fer.service.OfferSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferSellerServiceJpa implements OfferSellerService {
    @Autowired
    private OfferSellerRepository offerSellerRepository;
    @Override
    public List<OfferSeller> list() {
        return offerSellerRepository.findAll();
    }
}
