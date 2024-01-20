package hr.fer.dto;

import hr.fer.domain.Edition;

public class EditionDTO {
    // Book Values
    private String title;
    private String author;
    private String cover;
    private String description;
    private String genre;

    // Edition Values
    private long releaseYear, ISBN;
    private Boolean locallyPurchasable;
    private Edition.Type type;
    private String publisher;

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public Boolean getLocallyPurchasable() {
        return locallyPurchasable;
    }

    public Edition.Type getType() {
        return type;
    }

    public String getCover() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    public String getGenre() {
        return genre;
    }

    public String getPublisher() {
        return publisher;
    }
}
