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

    private Edition () {}

    public long getISBN() {
        return ISBN;
    }

    public Type getType() {
        return type;
    }

    public Boolean isLocallyPurchasable() {
        return locallyPurchasable;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public Book getBook() {
        return book;
    }

    public Publisher getPublisher() {
        return publisher;
    }
}
