package org.proggers.backend.endpoints;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/seller")
public class BookController {

    @GetMapping("")
    public String ping () {
        return "Welcome!";
    }

}
