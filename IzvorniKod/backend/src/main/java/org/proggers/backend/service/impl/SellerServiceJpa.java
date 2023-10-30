package org.proggers.backend.service.impl;

import org.proggers.backend.dao.SellerRepository;
import org.proggers.backend.domain.Seller;
import org.proggers.backend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SellerServiceJpa implements SellerService {
    @Autowired
    private SellerRepository sellerRepo;

    @Override
    public List<Seller> list() {
        return sellerRepo.findAll();
    }

    @Override
    public Seller createSeller(Seller seller) {
        Assert.notNull(seller, "Seller object cant be null.");
        Assert.isNull(seller.getId(), "Seller id must be null.");
        // TODO: Assertions to make sure Country, Email, etc. are of proper format.
        return sellerRepo.save(seller);
    }
}
