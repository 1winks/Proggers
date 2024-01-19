package hr.fer.dto;

import hr.fer.domain.Edition;

public class EditionDTO {
    private String title, author;
    private long releaseYear, ISBN;
    private Boolean locallyPurchasable;
    private Edition.Type type;

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
}
