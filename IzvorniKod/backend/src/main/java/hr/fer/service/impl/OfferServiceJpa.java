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
        Assert.notNull(offerDTO, "Offer DTO must not be null");

        Offer offer = new Offer(offerDTO);

        Seller seller = sellerRepo.findByMail(offerDTO.getSellerMail());

        Assert.notNull(seller, "Offer must have valid seller.");

        OfferSeller offerSeller = new OfferSeller(offer, seller)

        offer.link(offerSeller);
        seller.link(offerSeller);

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
