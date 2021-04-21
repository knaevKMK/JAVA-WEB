package casino.manager.attendent.repository;

import casino.manager.attendent.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Client findClientByEgn(String egn);
}
