package hr.fer.domain;

import hr.fer.dto.SellerDTO;
import hr.fer.entity.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "seller", schema = "public")
public class Seller {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Seller(SellerDTO sellerDTO) {
        this.name = sellerDTO.getName();
        this.address = sellerDTO.getAddress();
        this.country = sellerDTO.getCountry();
        this.mail = sellerDTO.getMail();
        this.telephone = sellerDTO.getTelephone();
        this.type = sellerDTO.getType();
        // TODO: Link up with User
    }

    public enum Type {
        PUBLISHER,
        ANTIQUARIAN,
        RESELLER;
    }

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false, unique = true)
    private String name, mail, telephone;

    @Column(nullable = false)
    private String address, country;

    @OneToOne(mappedBy = "seller")
    private User user;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<OfferSeller> offerSellers = new HashSet<>();

    public void link(OfferSeller offerSeller) {
        offerSellers.add(offerSeller);
    }

}