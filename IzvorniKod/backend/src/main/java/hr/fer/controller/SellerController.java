package hr.fer.controller;

import hr.fer.domain.Seller;
import hr.fer.dto.SellerDTO;
import hr.fer.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/sellers")
public class SellerController {
    @Autowired
    private SellerService sellerService;

    @GetMapping("")
    public List<Seller> listSellers() {
        return sellerService.list();
    }

    @PostMapping("add")
    public Seller createSeller(@RequestBody SellerDTO sellerDTO) {
        return sellerService.createSeller(sellerDTO);
    }

}