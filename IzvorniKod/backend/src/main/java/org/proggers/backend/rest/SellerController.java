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

    @PostMapping("/registration")
    public Seller createSeller(@RequestBody Seller seller) {
        return sellerService.createSeller(seller);
    }

//  name i password za login
    @PostMapping("/login")
    public boolean checkSeller(@RequestBody LoginUserDTO dto) {
        return sellerService.checkSeller(dto.getName(), dto.getPassword());
    }
}
