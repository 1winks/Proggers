package org.proggers.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Book {
    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title, author;

    @OneToMany(mappedBy = "book")
    private Set<Edition> edition;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}