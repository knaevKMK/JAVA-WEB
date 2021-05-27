package spring_fundametals.mobilele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_fundametals.mobilele.model.entites.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsernameAAndPassword(String username, String password);
}
