package org.proggers.backend.rest;

import org.proggers.backend.domain.Seller;
import org.proggers.backend.dto.LoginUserDTO;
import org.proggers.backend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping("")
    public List<Seller> listSellers() {
        return sellerService.list();
    }

    @PostMapping("/create")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

}
