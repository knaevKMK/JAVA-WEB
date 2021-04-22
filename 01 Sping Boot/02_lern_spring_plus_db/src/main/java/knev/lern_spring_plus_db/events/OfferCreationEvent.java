package knev.lern_spring_plus_db.events;

import knev.lern_spring_plus_db.models.Offer;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
@ToString

public class OfferCreationEvent {
    private final Offer offer;
}
