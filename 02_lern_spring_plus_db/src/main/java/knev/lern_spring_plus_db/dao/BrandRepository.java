package knev.lern_spring_plus_db.dao;

import knev.lern_spring_plus_db.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BrandRepository extends JpaRepository<Brand, UUID> {
}
