package org.proggers.backend.dao;

import org.proggers.backend.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SellerRepository extends JpaRepository<Seller, Long> {
    // TODO: Write custom SQL commands here using @Query. (https://stackoverflow.com/questions/33153271/how-do-you-create-a-spring-jpa-repository-findby-query-using-a-property-that-con)
    int countByMail(String mail);

    int countByName(String name);

    int countByTelephone(String telephone);

    /*

    @Query("SELECT count(*) FROM Seller g WHERE :n=g.name AND :p = g.password")
    int findByNameAndPassword(@Param("n") String name, @Param("p") String password);
    // TODO: odkomentirati nakon sto se password napravi

*/

}