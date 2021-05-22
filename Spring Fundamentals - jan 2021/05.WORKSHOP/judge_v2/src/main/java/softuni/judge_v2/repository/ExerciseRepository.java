package softuni.judge_v2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.judge_v2.model.entities.ExerciseEntity;


@Repository
public interface ExerciseRepository extends JpaRepository<ExerciseEntity,Long> {
}
