package knev.lern_spring_plus_db.repository;

import knev.lern_spring_plus_db.models.Stundent;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Stundent,Long> {
}
