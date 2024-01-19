package hr.fer.controller;

import hr.fer.domain.Book;
import hr.fer.domain.SellerEdition;
import hr.fer.service.BookService;
import hr.fer.service.SellerEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/seller-edition")
public class SellerEditionController {
    @Autowired
    private SellerEditionService sellerEditionService;

    @GetMapping("")
    public List<SellerEdition> listSellerEditions() {
        return sellerEditionService.list();
    }
}
