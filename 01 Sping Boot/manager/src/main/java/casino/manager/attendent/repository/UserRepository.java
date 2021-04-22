package casino.manager.attendent.repository;

import casino.manager.attendent.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}
