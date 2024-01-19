package hr.fer.repository;

import hr.fer.domain.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditionRepository extends JpaRepository<Edition, Long> {

    List<Edition> findByType(Edition.Type type);

    List<Edition> findByISBN(String isbn);

    List<Edition> findByReleaseYear(int releaseYear);
}
