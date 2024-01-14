package hr.fer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "offer", schema = "public")
public class Offer {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public enum State {
        NEW,
        USED;
    }

    /**
     * Stanje ocuvanja primjeraka
     */
    @Enumerated(EnumType.STRING)
    private State state;

    /**
     * Broj primjeraka na prodaji
     */
    @Column(nullable = false)
    private long copies;

    /**
     * Prodavac ponude
     */
    @ManyToOne @JoinColumn(name = "seller-id")
    private Seller seller;

    /**
     * Izdanje knjige koje se prodaje.
     */
    @ManyToOne @JoinColumn(name = "edition-id")
    private Edition edition;

    public long getId() {
        return id;
    }

    public State getState() {
        return state;
    }

    public long getCopies() {
        return copies;
    }

    public Seller getSeller() {
        return seller;
    }

    public Edition getEdition() {
        return edition;
    }
}
