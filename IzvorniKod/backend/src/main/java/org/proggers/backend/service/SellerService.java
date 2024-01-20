package org.proggers.backend.service;

import org.proggers.backend.dto.RegisterDTO;
import org.proggers.backend.entity.Seller;

public interface SellerService {
    void register (Seller seller);
    boolean exists (String username, String email);
    Seller find (String username);
}
