package org.proggers.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.proggers.backend.dto.BookDTO;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String publisher;

    private int publicationYear;

    public enum PublisherCategory {
        FOREIGN,
        LOCAL
    }
    private PublisherCategory publisherCategory;
    private String genre;
    private String isbn;

    public enum Condition {
        NEW,
        USED
    }

    private Condition condition;
    private int copies;
    private String description;

    public enum LanguageTag {
        FOREIGN,
        RELATED,
        NATIVE
    }
    private LanguageTag languageTag;
    private String address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public Book () {}

    public Book(BookDTO bookDTO, Seller seller) {
        this.title = bookDTO.getTitle();
        this.author = bookDTO.getAuthor();
        this.publisher = bookDTO.getPublisher();
        this.publicationYear = bookDTO.getPublicationYear();
        this.publisherCategory = bookDTO.getPublisherCategory();
        this.genre = bookDTO.getGenre();
        this.isbn = bookDTO.getIsbn();
        this.condition = bookDTO.getCondition();
        this.copies = bookDTO.getCopies();
        this.description = bookDTO.getDescription();
        this.languageTag = bookDTO.getLanguageTag();
        this.address = bookDTO.getAddress();
        this.seller = seller;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public PublisherCategory getPublisherCategory() {
        return publisherCategory;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Condition getCondition() {
        return condition;
    }

    public int getCopies() {
        return copies;
    }

    public String getDescription() {
        return description;
    }

    public LanguageTag getLanguageTag() {
        return languageTag;
    }

    public String getAddress() {
        return address;
    }
}