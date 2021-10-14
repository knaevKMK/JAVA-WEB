package exam.music.service.impl;

import exam.music.model.entity.Category;
import exam.music.model.entity.CategoryNameEnum;
import exam.music.repository.CategoryRepository;
import exam.music.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedData() {
        if (this.categoryRepository.count()==0){
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {

                        this.categoryRepository.saveAndFlush(new Category( categoryNameEnum,
                                String.format("Description for %s", categoryNameEnum.name())));
                    });
        }
    }

    @Override
    public Category findByName(CategoryNameEnum category) {

        return this.categoryRepository.findByName(category);

    }

    @Override
    public String findById(String id) {
        Optional<Category> category = this.categoryRepository.findById(id);
        return category.get().getName().name();
    }
}
