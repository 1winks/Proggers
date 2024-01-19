package hr.fer.domain;

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

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    private Set<SellerEdition> sellerEditions = new HashSet<>();

    public void link(OfferSeller offerSeller) {
        offerSellers.add(offerSeller);
    }

    public void link(SellerEdition sellerEdition) {
        sellerEditions.add(sellerEdition);
    }
}