package hr.fer.service;

import hr.fer.domain.Offer;
import hr.fer.dto.OfferDTO;

import java.util.List;

public interface OfferService {
    Offer createOffer(OfferDTO offerDTO);

    List<Offer> list();
}
