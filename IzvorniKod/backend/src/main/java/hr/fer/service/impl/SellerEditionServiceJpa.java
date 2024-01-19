package hr.fer.service.impl;

import hr.fer.domain.Book;
import hr.fer.domain.SellerEdition;
import hr.fer.repository.BookRepository;
import hr.fer.repository.SellerEditionRepository;
import hr.fer.service.SellerEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SellerEditionServiceJpa implements SellerEditionService {
    @Autowired
    private SellerEditionRepository sellerEditionRepository;
    @Override
    public List<SellerEdition> list() {
        return sellerEditionRepository.findAll();
    }
}
