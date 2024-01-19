package hr.fer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.fer.dto.OfferDTO;
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
@Table(name = "offer", schema = "public")
public class Offer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public enum State {
        NEW,
        USED;
    }

    public Offer (OfferDTO dto) {
        this.copies = dto.getCopies();
        this.state = dto.getState();
    }

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(nullable = false)
    private long copies;

    @JsonIgnore
    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private Set<EditionOffer> editionOffers = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL)
    private Set<OfferSeller> offerSellers = new HashSet<>();

    public void link (EditionOffer editionOffer) {
        editionOffers.add(editionOffer);
    }

    public void link(OfferSeller offerSeller) {
        offerSellers.add(offerSeller);
    }
}
