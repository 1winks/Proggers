package org.proggers.backend.domain;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    // TODO: Salt and hash with BCrypt
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean authorized;

    @OneToOne(optional = true)
    private Seller seller;

    private Account () {}

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public Seller getSeller() {
        return seller;
    }
}
