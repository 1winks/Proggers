package hr.fer.service.impl;

import hr.fer.domain.Seller;
import hr.fer.entity.auth.User;
import hr.fer.repository.SellerRepository;
import hr.fer.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Seller createSeller(User seller) {
        return null;
    }

    @Override
    public void remove(String username) {
        sellerRepo.removeSellerByName(username);
    }
}
