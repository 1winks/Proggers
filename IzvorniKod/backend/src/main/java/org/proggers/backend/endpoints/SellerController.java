package org.proggers.backend.endpoints;

import org.proggers.backend.dto.BookDTO;
import org.proggers.backend.entity.Book;
import org.proggers.backend.entity.Seller;
import org.proggers.backend.service.BookService;
import org.proggers.backend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    SellerService sellerService;

    @Autowired
    BookService bookService;

    @PostMapping("/addBook")
    public ResponseEntity<Void> addBook (@RequestBody BookDTO bookDTO) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String user = authentication.getName();

        Seller seller = sellerService.find(user);

        System.out.println(user);

        Book book = new Book(bookDTO, seller);
        bookService.add(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
