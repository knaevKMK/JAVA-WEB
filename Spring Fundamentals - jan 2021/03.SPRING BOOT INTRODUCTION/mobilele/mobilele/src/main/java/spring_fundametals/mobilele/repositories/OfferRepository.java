package spring_fundametals.mobilele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_fundametals.mobilele.model.entites.OfferEntity;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {
}
