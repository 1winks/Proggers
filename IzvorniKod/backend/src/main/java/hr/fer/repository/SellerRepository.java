package hr.fer.repository;

import hr.fer.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    int countByMail(String mail);

    int countByName(String name);

    int countByTelephone(String telephone);

    @Query("SELECT g FROM Seller g WHERE g.name=:n")
    Seller findByName(@Param("n") String name);

    void removeSellerByName(String name);

    Seller findByMail(String mail);
}
