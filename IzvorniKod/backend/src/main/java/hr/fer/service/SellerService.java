package hr.fer.service;


import hr.fer.domain.Seller;
import hr.fer.entity.auth.User;

import java.util.List;

public interface SellerService {
    List<Seller> list();

//    List<Seller> list(Seller.Type type);

    Seller createSeller(User seller);

    void remove(String username);
}
