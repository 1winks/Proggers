package hr.fer.service;

import hr.fer.domain.Offer;
import hr.fer.dto.OfferDTO;
import hr.fer.dto.SearchDTO;

import java.util.List;

public interface OfferService {
    Offer createOffer(OfferDTO offerDTO);

    List<Offer> findOffers (SearchDTO search);

    List<Offer> list();
}
