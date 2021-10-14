package exam.music.repository;

import exam.music.model.entity.Classification;
import exam.music.model.entity.ClassificationEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification,String> {


    Classification findByClassificationName(ClassificationEnum classification);
}
