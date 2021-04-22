package casino.manager.attendent.repository;

import casino.manager.attendent.entity.Accountant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountantRepository extends JpaRepository<Accountant, UUID> {
}
