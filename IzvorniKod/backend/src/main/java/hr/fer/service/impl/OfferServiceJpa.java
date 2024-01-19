package hr.fer.service.impl;

import hr.fer.controller.OfferController;
import hr.fer.domain.Book;
import hr.fer.domain.Offer;
import hr.fer.domain.OfferSeller;
import hr.fer.domain.Seller;
import hr.fer.dto.OfferDTO;
import hr.fer.repository.BookRepository;
import hr.fer.repository.OfferRepository;
import hr.fer.repository.OfferSellerRepository;
import hr.fer.repository.SellerRepository;
import hr.fer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OfferServiceJpa implements OfferService {
    @Autowired
    private OfferRepository offerRepo;
    @Autowired
    private SellerRepository sellerRepo;
    @Autowired
    private OfferSellerRepository offerSellerRepo;

    @Override
    public Offer createOffer(OfferDTO offerDTO) {
        Offer offer = new Offer();
        offer.setCopies(offerDTO.getCopies());
        offer.setState(offerDTO.getState());

        Seller seller = sellerRepo.findByMail(offerDTO.getSellerMail());

        OfferSeller offerSeller = new OfferSeller();
        offerSeller.setOffer(offer);
        offerSeller.setSeller(seller);

        Set<OfferSeller> offerSellers = offer.getOfferSellers();
        offerSellers.add(offerSeller);
        offer.setOfferSellers(offerSellers);

        offerSellers = seller.getOfferSellers();
        offerSellers.add(offerSeller);
        seller.setOfferSellers(offerSellers);

        offerSellerRepo.save(offerSeller);
        sellerRepo.save(seller);
        offerRepo.save(offer);
        return offer;
    }

    @Override
    public List<Offer> list() {
        return offerRepo.findAll();
    }
}
