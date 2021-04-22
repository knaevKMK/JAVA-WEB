package casino.manager.attendent.repository;

import casino.manager.attendent.entity.GamblingMachine;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface GamblingMachineRepository extends JpaRepository<GamblingMachine, UUID> {
}
