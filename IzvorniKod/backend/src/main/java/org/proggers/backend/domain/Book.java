package org.proggers.backend.domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title, language;

    @ManyToOne @JoinColumn(name = "sellerId")
    private Seller seller;

    public Book(Long id, String title, String language, Seller seller) {
        this.id = id;
        this.title = title;
        this.language = language;
        this.seller = seller;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getLanguage() {
        return language;
    }

    public Seller getSeller() {
        return seller;
    }
}