package hr.fer.controller;

import hr.fer.domain.Book;
import hr.fer.domain.Edition;
import hr.fer.service.BookService;
import hr.fer.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/editions")
public class EditionController {
    @Autowired
    private EditionService editionService;

    @GetMapping("")
    public List<Edition> listEditions() {
        return editionService.list();
    }
}
