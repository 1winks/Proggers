package org.proggers.backend.domain;

import jakarta.persistence.*;

import java.util.List;

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

    @Column(nullable = false)
    private String name, mail, address, city, country, telephone;

    @OneToMany(mappedBy = "seller")
    private List<Book> books;

    private Seller() {};

    public Seller(Long id, Type type, String name, String mail, String address, String city, String country, String telephone) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.mail = mail;
        this.address = address;
        this.city = city;
        this.country = country;
        this.telephone = telephone;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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