package hr.fer.service.impl;

import hr.fer.domain.Seller;
import hr.fer.dto.SellerDTO;
import hr.fer.entity.auth.User;
import hr.fer.repository.SellerRepository;
import hr.fer.repository.UserRepository;
import hr.fer.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        User user = userRepository.findByEmail(sellerDTO.getMail());

        Seller seller = new Seller();
        seller.setName(sellerDTO.getName());
        seller.setMail(sellerDTO.getMail());
        seller.setAddress(sellerDTO.getAddress());
        seller.setCountry(sellerDTO.getCountry());
        seller.setTelephone(sellerDTO.getTelephone());
        seller.setType(sellerDTO.getType());

        seller.setUser(user);
        user.setSeller(seller);

        return sellerRepo.save(seller);
    }

    @Override
    public void remove(String username) {
        sellerRepo.removeSellerByName(username);
    }
}
