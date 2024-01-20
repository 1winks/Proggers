package hr.fer.service;

import hr.fer.domain.Edition;
import hr.fer.dto.EditionDTO;
import hr.fer.dto.SearchDTO;

import java.util.List;

public interface EditionService {
    List<Edition> list();
    Edition addEdition(EditionDTO edition);
    List<Edition> searchEdition (SearchDTO search);
}
