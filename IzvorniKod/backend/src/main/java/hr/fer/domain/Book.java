package hr.fer.domain;


import hr.fer.dto.BookDTO;
import hr.fer.dto.EditionDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Entity
@Table(name = "book", schema = "public")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    public Book (BookDTO bookDTO) {

    }
    @Column(nullable = false)
    private String title, author, cover, description, genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private Set<BookEdition> bookEditions = new HashSet<>();

    public Book(EditionDTO editionDTO) {
        this.author = editionDTO.getAuthor();
        this.cover = editionDTO.getCover();
        this.genre = editionDTO.getGenre();
        this.title = editionDTO.getTitle();
        this.description = editionDTO.getDescription();
    }

    public void link (BookEdition bookEdition) {
        bookEditions.add(bookEdition);
    }
}
