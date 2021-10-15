package exam.music.service;

import exam.music.model.entity.CategoryEntity;

public interface CategoryService {
    void seedData();

    CategoryEntity findByName(String name);
}
