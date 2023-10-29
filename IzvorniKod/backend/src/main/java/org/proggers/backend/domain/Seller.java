package org.proggers.backend.domain;

import jakarta.persistence.*;

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

    private String name, mail, address, telephone;

    public Seller(Long id, Type type, String name, String mail, String address, String telephone) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.mail = mail;
        this.address = address;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}