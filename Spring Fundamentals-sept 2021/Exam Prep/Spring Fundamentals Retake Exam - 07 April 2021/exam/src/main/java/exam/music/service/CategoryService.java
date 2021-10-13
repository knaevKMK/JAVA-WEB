package exam.music.service;

import exam.music.model.entity.Category;
import exam.music.model.entity.CategoryNameEnum;

public interface CategoryService {
    void seedData();

    Category getByName(CategoryNameEnum category);
}
