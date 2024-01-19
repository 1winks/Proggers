package hr.fer.dto;

import hr.fer.domain.Offer;

public class OfferDTO {
    private long copies;
    private Offer.State state;

    public long getCopies() {
        return copies;
    }
    public void setCopies(long copies) {
        this.copies = copies;
    }
    public Offer.State getState() {
        return state;
    }
    public void setState(Offer.State state) {
        this.state = state;
    }
}
