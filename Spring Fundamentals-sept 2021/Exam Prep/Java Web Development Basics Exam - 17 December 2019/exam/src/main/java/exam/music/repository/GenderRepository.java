package exam.music.repository;

import exam.music.model.entity.SexEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepository extends JpaRepository<SexEntity, Integer> {
    SexEntity findByGender(String name);
}
