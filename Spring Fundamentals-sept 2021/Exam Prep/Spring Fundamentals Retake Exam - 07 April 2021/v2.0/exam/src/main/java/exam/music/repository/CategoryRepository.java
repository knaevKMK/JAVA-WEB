package exam.music.repository;

import exam.music.model.entity.CategoryEntity;
import exam.music.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    CategoryEntity findByName(CategoryNameEnum name);
}
