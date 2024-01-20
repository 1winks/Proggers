package hr.fer.controller;

import hr.fer.domain.Book;
import hr.fer.domain.Edition;
import hr.fer.dto.EditionDTO;
import hr.fer.dto.SearchDTO;
import hr.fer.service.BookService;
import hr.fer.service.EditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public Edition addEdition (@RequestBody EditionDTO editionDTO) {
        return editionService.addEdition(editionDTO);
    }

    @PostMapping("/search")
    public List<Edition> searchEditions (@RequestBody SearchDTO searchDTO) {
        return editionService.searchEdition(searchDTO);
    }
}
