package org.proggers.backend.repository;
import org.proggers.backend.entity.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    Optional<Seller> findByUsername(String username);

    Optional<Seller> findByEmail(String email);

    List<Seller> findByVerified(boolean verified);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
