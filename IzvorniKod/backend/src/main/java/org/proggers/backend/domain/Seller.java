package org.proggers.backend.domain;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Seller {
    @Id @GeneratedValue
    private Long id;

    public enum Type {
        PUBLISHER,
        ANTIQUARIAN,
        RESELLER;
    }

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false, unique = true)
    private String name, mail, telephone;

    @Column(nullable = false)
    private String address, country;

    @OneToMany(mappedBy = "seller")
    private Set<Offer> offers;

    private Seller() {};

    public Long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}