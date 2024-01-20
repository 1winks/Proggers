package hr.fer.service.impl;

import hr.fer.domain.Seller;
import hr.fer.dto.SellerDTO;
import hr.fer.entity.auth.User;
import hr.fer.repository.SellerRepository;
import hr.fer.repository.UserRepository;
import hr.fer.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class SellerServiceJpa implements SellerService {
    @Autowired
    private SellerRepository sellerRepo;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Seller> list() {
        return sellerRepo.findAll();
    }

    @Override
    public Seller createSeller(SellerDTO sellerDTO) {
        Assert.notNull(sellerDTO, "Seller DTO must not be null");

        Seller seller = new Seller(sellerDTO);

        sellerRepo.save(seller);
        return seller;
    }

    @Override
    public void remove(String username) {
        sellerRepo.removeSellerByName(username);
    }
}
