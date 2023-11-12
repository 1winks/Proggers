package org.proggers.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Publisher {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public enum Type {
        FOREIGN,
        LOCAL
    }

    @Enumerated(EnumType.STRING)
    private Type type;

    // TODO: Update this variable with linked Seller name. (If seller name is changeable...)
    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "publisher")
    private Seller seller;

    @OneToMany(mappedBy = "publisher")
    private Set<Edition> editions;
}
