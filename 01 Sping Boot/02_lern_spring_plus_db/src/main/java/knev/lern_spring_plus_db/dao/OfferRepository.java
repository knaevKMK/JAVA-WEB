package knev.lern_spring_plus_db.dao;

import knev.lern_spring_plus_db.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfferRepository extends JpaRepository<Offer, UUID> {

}
