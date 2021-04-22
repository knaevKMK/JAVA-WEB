package knev.lern_spring_plus_db.service;

import knev.lern_spring_plus_db.models.Offer;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public interface OfferService {
    Collection<Offer> getOffers();
    Offer getOfferById(UUID id);
    Offer createOffer(Offer offer);
    Offer updateOffer(Offer offer);
    Offer deleteOffer(UUID id);
    long getOffersCount();
    List<Offer> createOffersBatch(List<Offer> offers);
}
