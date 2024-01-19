package hr.fer.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hr.fer.dto.EditionDTO;
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
@Table(name = "edition", schema = "public")
public class Edition {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ISBN;

    public enum Type {
        FOREIGN,
        TRANSLATED,
        RELATED;
    }

    public Edition (EditionDTO dto) {
        this.type = dto.getType();
        this.ISBN = dto.getISBN();
        this.type = dto.getType();
        this.locallyPurchasable = dto.getLocallyPurchasable();
        this.releaseYear = dto.getReleaseYear();
    }


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;

    @Column(nullable = false)
    private Boolean locallyPurchasable;

    @Column(nullable = false)
    private long releaseYear;

    @JsonIgnore
    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private Set<BookEdition> bookEditions = new HashSet<>();

    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private Set<EditionOffer> editionOffers = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "edition", cascade = CascadeType.ALL)
    private Set<SellerEdition> sellerEditions = new HashSet<>();


}
