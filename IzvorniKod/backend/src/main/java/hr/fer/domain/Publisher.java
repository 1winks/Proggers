package hr.fer.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "publisher", schema = "public")
public class Publisher {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    public enum Type {
        FOREIGN,
        LOCAL
    }

    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "publisher")
    private Seller seller;

    @OneToMany(mappedBy = "publisher")
    private Set<Edition> editions;

    public long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public Seller getSeller() {
        return seller;
    }

    public Set<Edition> getEditions() {
        return editions;
    }
}

