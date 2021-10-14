package exam.music.repository;

import exam.music.model.entity.Category;
import exam.music.model.entity.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {


    Category findByName(CategoryNameEnum category);
}
