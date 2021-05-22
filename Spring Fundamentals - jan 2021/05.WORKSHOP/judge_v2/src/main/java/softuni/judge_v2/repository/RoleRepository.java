package softuni.judge_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge_v2.model.entities.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {
}
