package spring_fundametals.mobilele.services.impl;


import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import spring_fundametals.mobilele.model.entites.OfferEntity;
import spring_fundametals.mobilele.model.view.OfferViewModel;
import spring_fundametals.mobilele.repositories.OfferRepository;
import spring_fundametals.mobilele.services.OfferService;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<OfferViewModel> getAllOffers() {
        List<OfferViewModel> result = new ArrayList<>();
        List<OfferEntity> allOfferEntity = this.offerRepository.findAll();
        ModelMapper mapper = new ModelMapper();

        allOfferEntity.forEach(oe -> {
            OfferViewModel newOferViewModel = new OfferViewModel();
            mapper.map(oe, newOferViewModel);
            result.add(newOferViewModel);
        });
        return result;
    }
}
