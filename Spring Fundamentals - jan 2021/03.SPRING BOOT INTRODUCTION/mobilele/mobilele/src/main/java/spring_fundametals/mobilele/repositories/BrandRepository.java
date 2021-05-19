package spring_fundametals.mobilele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_fundametals.mobilele.model.entites.BrandEntity;


@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
}
