package hr.fer.controller;

import hr.fer.domain.Book;
import hr.fer.domain.OfferSeller;
import hr.fer.service.BookService;
import hr.fer.service.OfferSellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/offer-seller")
public class OfferSellerController {
    @Autowired
    private OfferSellerService offerSellerService;

    @GetMapping("")
    public List<OfferSeller> listOfferSellers() {
        return offerSellerService.list();
    }
}
