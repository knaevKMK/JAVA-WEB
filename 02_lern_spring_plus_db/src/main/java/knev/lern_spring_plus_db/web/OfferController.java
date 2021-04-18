package knev.lern_spring_plus_db.web;

import knev.lern_spring_plus_db.models.Views;
import knev.lern_spring_plus_db.service.OfferService;
import knev.lern_spring_plus_db.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/offers")
@CrossOrigin("http://localhost:3000")

public class OfferController {


    @Autowired
    OfferService offerService;

    @Autowired
    UserService userService;

    @GetMapping
    @JsonView(Views.Offer.class)
    public Collection<Offer> getOffers() {
        return offerService.getOffers();
    }

    @GetMapping("{id}")
    @JsonView(Views.Offer.class)
    public Offer getOffers(@PathVariable UUID id) {
        return offerService.getOfferById(id);
    }

    @DeleteMapping("{id}")
    @JsonView(Views.Offer.class)
    public Offer deleteOffers(@PathVariable UUID id) {
        return offerService.deleteOffer(id);
    }

    @PostMapping
    @JsonView(Views.Offer.class)
    public ResponseEntity<Offer> addOffer(@RequestBody Offer offer, Authentication authentication) {
//        User author = userService.getUserByUsername(authentication.getName());
//        offer.setAuthor(author);
        Offer created = offerService.createOffer(offer);
        URI location = MvcUriComponentsBuilder.fromMethodName(OfferController.class, "addOffer", offer, authentication)
                .pathSegment("{id}").buildAndExpand(created.getId()).toUri() ;
        return ResponseEntity.created(location).body(created);
//        return ResponseEntity.status(303).location(location).body(created);
    }

    @PutMapping("{id}")
    @JsonView(Views.Offer.class)
    public ResponseEntity<Offer> updateOffer(@PathVariable long id, @RequestBody Offer offer) {
        if(offer.getId() != id) throw new InvalidEntityException(
                String.format("Offer ID=%s from path is different from Entity ID=%s", id, offer.getId()));
        Offer updated = offerService.updateOffer(offer);
        log.info("Offer updated: {}", updated);
        return ResponseEntity.ok(updated);
    }
}
