package hr.fer.service;


import hr.fer.domain.Seller;
import hr.fer.dto.SellerDTO;
import hr.fer.entity.auth.User;

import java.util.List;

public interface SellerService {
    List<Seller> list();

    Seller createSeller(SellerDTO sellerDTO);

    void remove(String username);
}
