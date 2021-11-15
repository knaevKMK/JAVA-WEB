package com.project.shop.service.impl;

import com.project.shop.model.entity.Offer;
import com.project.shop.repository.OfferRepository;
import com.project.shop.service.OfferService;
import org.springframework.stereotype.Service;

@Service
public class OfferServiceImpl extends BaseServiceImpl<Offer> implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Offer save(Offer offer) {
     return    this.offerRepository.save(offer);
    }
}
