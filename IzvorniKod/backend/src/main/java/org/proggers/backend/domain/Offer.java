package org.proggers.backend.domain;

import jakarta.persistence.*;

@Entity
public class Offer {

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
}
