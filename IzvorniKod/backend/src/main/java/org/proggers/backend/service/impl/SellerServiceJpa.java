package org.proggers.backend.service.impl;

import org.proggers.backend.dao.SellerRepository;
import org.proggers.backend.domain.Seller;
import org.proggers.backend.dto.RegistrationUserDTO;
import org.proggers.backend.rest.SellerController;
import org.proggers.backend.service.RequestDeniedException;
import org.proggers.backend.service.SellerService;
import org.proggers.backend.domain.Seller.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import javax.naming.Name;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Service
public class SellerServiceJpa implements SellerService {
    @Autowired
    private SellerRepository sellerRepo;

    @Override
    public List<Seller> list() {
        return sellerRepo.findAll();
    }

    @Override
    public Seller createSeller(RegistrationUserDTO regData) {
        Assert.notNull(regData, "Registration data can't be null.");

        Seller seller = new Seller(regData);

        Assert.notNull(seller, "Seller object can't be null.");

        Assert.isNull(seller.getId(), "Seller id must be null.");

        Assert.notNull(seller.getName(), "Seller must have a name.");
        Assert.hasText(seller.getName(), "Seller must have a name.");

        Type sellerType = seller.getType();
        Assert.notNull(seller.getType(), "Seller type can't be null.");

        String sellerCountryCode = seller.getCountry();
        Assert.hasText(sellerCountryCode, "Seller country can't be empty.");
        Assert.isTrue(Arrays.asList(Locale.getISOCountries()).contains(sellerCountryCode), "Seller country is not valid.");

        String sellerAddress = seller.getAddress();
        Assert.hasText(sellerAddress, "Seller address can't be empty.");

        if (sellerType == Type.PUBLISHER) {
            Assert.isTrue(sellerCountryCode.equals("HR"), "Antiquarian must be from Croatia.");
        } else if (sellerType == Type.RESELLER) {
            List<String> relatedCountriesCodes = Arrays.asList("HR", "SI", "RS", "BA", "ME"); //Hrvatska, Slovenija, Srbija, Bosna i Hercegovina, Crna Gora
            Assert.isTrue(relatedCountriesCodes.contains(sellerCountryCode), "Reseller must be from Croatia or countries with a related language.");
        }
        
        String sellerMail = seller.getMail();
        int i = sellerMail.indexOf('@');
        Assert.isTrue(i != -1, "Email must have @");
        sellerMail = sellerMail.substring(0, i + 1) + sellerMail.substring(i + 1).toLowerCase();
        seller.setMail(sellerMail);
        Assert.hasText(sellerMail, "Email must not be empty.");
        Assert.isTrue(sellerMail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,6}$"), "Email is not in a valid format.");
        
        Assert.notNull(seller.getTelephone(), "Telephone can't be null.");
        Assert.isTrue(seller.getTelephone().matches("^(\\+\\d{1,4})?\\d{1,4}?[\\s]?\\d{3,4}[\\s]?\\d{3,4}[\\s]?(\\d{3,4}[\\s])?$"), "Telephone is not valid.");

        if(sellerRepo.countByMail(seller.getMail())>0)
            throw new RequestDeniedException(
                    "Seller with email: " + seller.getMail() + " already exists"
            );

        if(sellerRepo.countByName(seller.getName())>0)
            throw new RequestDeniedException(
                    "Seller with name: " + seller.getName() + " already exists"
            );

        if(sellerRepo.countByTelephone(seller.getTelephone())>0)
            throw new RequestDeniedException(
                    "Seller with telephone: " + seller.getTelephone() + " already exists"
            );

        return sellerRepo.save(seller);
    }

    @Override
    public void remove(String username) {
        // TODO: Assertions
        sellerRepo.removeSellerByName(username);
    }
}
