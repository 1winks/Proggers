package org.proggers.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title, author, cover, description, genre;

    @OneToMany(mappedBy = "book")
    private Set<Edition> editions;

    private Book () {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCover() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public Set<Edition> getEditions() {
        return editions;
    }
}