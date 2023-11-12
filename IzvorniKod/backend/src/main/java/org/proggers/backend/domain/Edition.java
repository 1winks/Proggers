package org.proggers.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Edition {
    @Id
    private long ISBN;

    public enum Type {
        /**
         * Knjiga na stranom jeziku
         */
        FOREIGN,
        /**
         * Knjiga izdana na hrvatskom jeziku
         */
        TRANSLATED,
        /**
         * Knjiga izdana na srodnom jeziku
         */
        RELATED;
    }

    // TODO: Spojiti sa novim izdavac entitetom (Ne mora biti registrirani korisnik Seller)

    @Enumerated(EnumType.STRING) @Column(nullable = false)
    private Type type;

    /**
     * Knjiga se moze dobaviti na podrucju Hrvatske
     */
    @Column(nullable = false)
    private Boolean locallyPurchasable;

    /**
     * Godina Izdanja
     */
    @Column(nullable = false)
    private long releaseYear;

    @OneToMany(mappedBy = "edition")
    private Set<Offer> offers;

    @ManyToOne @JoinColumn(name = "book-id")
    private Book book;

    @ManyToOne @JoinColumn(name = "publisher-id")
    private Publisher publisher;
}
