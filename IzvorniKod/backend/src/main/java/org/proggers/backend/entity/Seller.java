package org.proggers.backend.entity;

import jakarta.persistence.*;
import org.proggers.backend.dto.RegisterDTO;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    public enum Type {
        ANTIQUARIAN,
        RESELLER,
        PUBLISHER
    }
    @Enumerated(EnumType.STRING)
    private Type type;

    private String telephone;
    private String address;
    private String country;

    public Seller () {}
    public Seller(RegisterDTO registrationDTO, PasswordEncoder encoder) {
        this.username = registrationDTO.getUsername();
        this.password = encoder.encode(registrationDTO.getPassword());
        this.email = registrationDTO.getEmail();
        this.type = registrationDTO.getType();
        this.telephone = registrationDTO.getTelephone();
        this.address = registrationDTO.getAddress();
        this.country = registrationDTO.getCountry();
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

    public String getEmail() {
        return email;
    }

    public Type getType() {
        return type;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }
}