package org.proggers.backend.dto;

import org.proggers.backend.entity.Book;

public class BookDTO {
    private String title;
    private String author;
    private String publisher;
    private int publicationYear;
    private Book.PublisherCategory publisherCategory;
    private String genre;
    private String isbn;
    private Book.Condition condition;
    private int copies;
    private String description;
    private Book.LanguageTag languageTag;
    private String address;

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

    public Book.PublisherCategory getPublisherCategory() {
        return publisherCategory;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Book.Condition getCondition() {
        return condition;
    }

    public int getCopies() {
        return copies;
    }

    public String getDescription() {
        return description;
    }

    public Book.LanguageTag getLanguageTag() {
        return languageTag;
    }

    public String getAddress() {
        return address;
    }
}
