package org.proggers.backend.service;

import org.proggers.backend.entity.Seller;

import java.util.List;

public interface SellerService {
    void update(Seller seller);
    boolean exists (String username, String email);
    Seller find (String username);

    List<Seller> unverified ();
}
