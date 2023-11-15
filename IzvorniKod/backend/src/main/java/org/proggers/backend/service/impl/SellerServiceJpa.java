package org.proggers.backend.service.impl;

import org.proggers.backend.dao.SellerRepository;
import org.proggers.backend.domain.Seller;
import org.proggers.backend.service.SellerService;
import org.proggers.backend.domain.Seller.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Arrays;
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
    public Seller createSeller(Seller seller) {
        Assert.notNull(seller, "Seller object can't be null.");

        Assert.isNull(seller.getId(), "Seller id must be null.");

        Type sellerType = seller.getType();
        Assert.notNull(seller.getType(), "Seller type can't be null.");

        String sellerCountry = seller.getCountry();
        Assert.hasText(sellerCountry, "Seller country can't be empty.");

        if (sellerType == Type.PUBLISHER) {
            Assert.isTrue(sellerCountry.equals("Croatia"), "Antiquarian must be from Croatia.");
        } else if (sellerType == Type.RESELLER) {
            List<String> relatedCountries = Arrays.asList("Croatia", "Slovenia", "Serbia", "Bosnia and Herzegovina", "Montenegro");
            Assert.isTrue(relatedCountries.contains(sellerCountry), "Reseller must be from Croatia or countries with a related language.");
        }

        String sellerMail = seller.getMail();
        Assert.hasText(sellerMail, "Email must not be empty.");
        Assert.isTrue(sellerMail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$"), "Email is not in a valid format.");
        
        Assert.notNull(seller.getTelephone(), "Telephone can't be null.");
        Assert.isTrue(seller.getTelephone().matches("^(\\+\\d{1,4})?\\d{1,4}?[\\s]?\\d{3,4}[\\s]?\\d{3,4}[\\s]?(\\d{3,4}[\\s])?$"), "Telephone is not valid.");

        return sellerRepo.save(seller);
    }
}
