package org.proggers.backend.service;

import org.proggers.backend.domain.Seller;
import org.proggers.backend.dto.RegistrationUserDTO;

import java.util.List;

/**
 * Service Wrapper that manages DB calls related to Sellers.
 * @see Seller
 */
public interface SellerService {
    List<Seller> list();

//    List<Seller> list(Seller.Type type);

    Seller createSeller(RegistrationUserDTO seller);

    void remove(String username);
}