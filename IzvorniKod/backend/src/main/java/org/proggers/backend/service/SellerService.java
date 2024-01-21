package org.proggers.backend.service;

import org.proggers.backend.entity.Seller;

public interface SellerService {
    void update(Seller seller);
    boolean exists (String username, String email);
    Seller find (String username);
}
