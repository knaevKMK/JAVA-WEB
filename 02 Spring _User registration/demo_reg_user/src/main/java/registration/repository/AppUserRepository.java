package registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import registration.entityUser.AppUser;

import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional(readOnly = true)
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
     Optional<AppUser> findAppUserByEmail(String email);
}
