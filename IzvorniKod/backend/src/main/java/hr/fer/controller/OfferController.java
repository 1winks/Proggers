package hr.fer.controller;

import hr.fer.domain.Book;
import hr.fer.domain.Offer;
import hr.fer.service.BookService;
import hr.fer.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping("")
    public List<Offer> listOffers() {
        return offerService.list();
    }
}
