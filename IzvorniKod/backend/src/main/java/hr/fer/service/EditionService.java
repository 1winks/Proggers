package hr.fer.service;

import hr.fer.domain.Edition;
import hr.fer.dto.EditionDTO;

import java.util.List;

public interface EditionService {
    List<Edition> list();

    Edition addEdition(EditionDTO edition);
}
