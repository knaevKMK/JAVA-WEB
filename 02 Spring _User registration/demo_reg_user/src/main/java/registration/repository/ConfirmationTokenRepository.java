package registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import registration.entityUser.ConfirmationToken;

import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository  extends JpaRepository<ConfirmationToken,Long> {

    Optional<ConfirmationToken> findByToken(String token);
}
