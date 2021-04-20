package reception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reception.entity.Client;

import java.util.UUID;


@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
}
