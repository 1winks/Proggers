package org.proggers.backend.domain;

import jakarta.persistence.*;
import org.proggers.backend.dto.RegistrationUserDTO;

@Entity
public class Account {
    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private boolean authorized;

    @OneToOne(optional = true)
    private Seller seller;

    private Account () {}

    public Account (RegistrationUserDTO regData) {
        this.username = regData.getName();
        this.password = regData.getPassword();
        this.authorized = false;
    }

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

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public void authorize() {
        authorized = true;
    }
}
