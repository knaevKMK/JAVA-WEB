package casino.manager.attendent.repository;

import casino.manager.attendent.entity.Attendant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AttendantRepository extends JpaRepository<Attendant, UUID> {
}
