package hr.fer.controller;

import hr.fer.domain.Book;
import hr.fer.domain.EditionOffer;
import hr.fer.service.BookService;
import hr.fer.service.EditionOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/edition-offer")
public class EditionOfferController {
    @Autowired
    private EditionOfferService editionOfferService;

    @GetMapping("")
    public List<EditionOffer> listEditionOffers() {
        return editionOfferService.list();
    }
}