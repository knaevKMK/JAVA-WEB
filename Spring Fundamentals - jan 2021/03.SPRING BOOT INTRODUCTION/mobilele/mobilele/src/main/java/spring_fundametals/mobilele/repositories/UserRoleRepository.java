package spring_fundametals.mobilele.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_fundametals.mobilele.model.entites.UserRoleEntity;
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long> {
}
