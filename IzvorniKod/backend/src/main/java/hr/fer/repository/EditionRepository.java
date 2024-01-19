package hr.fer.repository;

import hr.fer.domain.Edition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditionRepository extends JpaRepository<Edition, Long> {

}
