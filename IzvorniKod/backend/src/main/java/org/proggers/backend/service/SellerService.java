package org.proggers.backend.service;

import org.proggers.backend.domain.Seller;

import java.util.List;

/**
 * Service Wrapper that manages DB calls related to Sellers.
 * @see Seller
 */
public interface SellerService {
    List<Seller> list();
//    List<Seller> list(Seller.Type type);

    Seller createSeller(Seller seller);

    boolean checkSeller(String name, String password);
}