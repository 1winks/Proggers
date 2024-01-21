package org.proggers.backend.service.impl;

import org.proggers.backend.dto.RegisterDTO;
import org.proggers.backend.entity.Seller;
import org.proggers.backend.repository.SellerRepository;
import org.proggers.backend.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerServiceJpa implements SellerService {
    @Autowired
    SellerRepository sellerRepository;
    @Override
    public boolean exists(String username, String email) {
        return sellerRepository.existsByEmail(email) || sellerRepository.existsByUsername(username);
    }

    @Override
    public void update(Seller seller) {
        // TODO: Checks?
        sellerRepository.save(seller);
    }

    @Override
    public Seller find(String username) {
        Optional<Seller> seller = sellerRepository.findByUsername(username);
        return seller.orElse(null);
    }

}
