package exam.music.service;

import exam.music.model.entity.CategoryEntity;
import exam.music.model.entity.CategoryNameEnum;

public interface CategoryService {
    CategoryEntity findByName(CategoryNameEnum name);

    void seedData();

}
